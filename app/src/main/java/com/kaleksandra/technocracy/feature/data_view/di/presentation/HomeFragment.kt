package com.kaleksandra.technocracy.feature.data_view.di.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kaleksandra.technocracy.R
import com.kaleksandra.technocracy.core.ResponseResult
import com.kaleksandra.technocracy.databinding.FragmentHomeBinding
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.LocationModel
import com.kaleksandra.technocracy.feature.data_view.di.domain.models.ProfileModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.profile.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseResult.Success -> {
                    if (it.body == null)
                        viewModel.getRemoteProfile()
                    else {
                        updateProfile(it.body)
                        binding.progressBar.visibility = View.GONE
                        binding.imgNoConnection.visibility = View.GONE
                        binding.cardView.visibility = View.VISIBLE
                    }
                }
                is ResponseResult.Error -> {
                    if (it.code == 500) {
                        binding.cardView.visibility = View.GONE
                        binding.imgNoConnection.visibility = View.VISIBLE
                    }
                    binding.progressBar.visibility = View.GONE
                }
                is ResponseResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.cardView.visibility = View.GONE
                    binding.imgNoConnection.visibility = View.GONE
                }
            }
        }

        binding.apply {
            btnUpdate.setOnClickListener {
                cardView.visibility = View.INVISIBLE
                viewModel.getRemoteProfile()
            }

            btnCall.setOnClickListener {
                viewModel.profile.value.let {
                    viewModel.profile.value.let {
                        if (viewModel.profile.value is ResponseResult.Success) {
                            callTheNumber((viewModel.profile.value as ResponseResult.Success<ProfileModel?>).body!!.phone)
                        }
                    }
                    //viewModel.profile.value?.let { callTheNumber(it.phone) }
                }
            }

            tvCoordinates.setOnClickListener {
                viewModel.profile.value.let {
                    if (viewModel.profile.value is ResponseResult.Success) {
                        openMap((viewModel.profile.value as ResponseResult.Success<ProfileModel?>).body!!.location)
                    }
                }
                /*viewModel.profile.value.let {
                    viewModel.profile.value?.let { openMap(it.location) }
                }*/
            }
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun openMap(location: LocationModel) {
        val gmmIntentUri = Uri.parse(
            "geo:${location.coordinates.latitude},${location.coordinates.longitude}?q=" + Uri.encode(
                location.street.name
            )
        )
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        mapIntent.resolveActivity(requireContext().packageManager)?.let {
            startActivity(mapIntent)
        }
    }

    private fun callTheNumber(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun updateProfile(data: ProfileModel) {
        binding.apply {
            view.setBackgroundColor(viewModel.color!!)
            tvDob.text = updateDate(data.dob)
            tvName.text = "${data.name.first} ${data.name.last}"
            tvPhone.text = data.phone
            tvCountry.text = data.location.country
            tvCity.text = data.location.city
            tvStreet.text =
                "${data.location.street.name} ${data.location.street.number}"
            tvCoordinates.text =
                "${data.location.coordinates.latitude} ${data.location.coordinates.longitude}"
            Picasso.get().load(data.picture)
                .placeholder(R.drawable.ic_image_placeholder)
                .into(binding.imgFace)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun updateDate(dateString: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val date = formatter.parse(dateString)
        return SimpleDateFormat.getDateInstance().format(date!!)
    }
}