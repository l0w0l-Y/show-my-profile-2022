package com.kaleksandra.technocracy

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kaleksandra.technocracy.feature.data_view.di.data.db.dao.ProfileDao
import com.kaleksandra.technocracy.feature.data_view.di.data.db.dao.ProfileDatabase
import com.kaleksandra.technocracy.feature.data_view.di.data.entities.ProfileEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class EntityReadWriteTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    private lateinit var userDao: ProfileDao
    private lateinit var db: ProfileDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ProfileDatabase::class.java
        ).build()
        userDao = db.profileDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val id: Int = 1
        val profile: ProfileEntity = TestUtil.createOneProfile(id)
        userDao.insertProfile(profile)
        val byId = userDao.getProfile(id)
        MatcherAssert.assertThat(byId, CoreMatchers.equalTo(profile))
    }

    @Test
    @Throws(Exception::class)
    fun rewriteUser() {
        val id: Int = 1
        val profile: ProfileEntity = TestUtil.createOneProfile(id)
        val newProfile: ProfileEntity = TestUtil.changeProfileName(profile, "Alisa")
        userDao.insertProfile(profile)
        userDao.insertProfile(newProfile)
        val byId = userDao.getProfile(id)
        MatcherAssert.assertThat(byId, CoreMatchers.equalTo(newProfile))
        MatcherAssert.assertThat(byId, CoreMatchers.not(profile))
    }
}