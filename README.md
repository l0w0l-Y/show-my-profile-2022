# Technocracy test task 2022
## Language:
[English](https://github.com/l0w0l-Y/technocracy-test-task#eng)

[Русский](https://github.com/l0w0l-Y/technocracy-test-task#ru)
# RU
## Тестовое задание
Необходимо реализовать небольшое Android-приложение, отображающее фейковые
данные пользователя.
Результат должен быть выложен на github в открытом доступе

**Требования к приложению**

1. Отображение экрана профиля: фото, полное имя, дата рождение, номер телефона,
страна, город, улица, координаты
2. Возможность перехода по номеру телефона и координатам в стандартные
системные приложения (будет плюсом)
3. Возможность обновления данных на экране
4. Хранение данных в БД через Room (будет плюсом)
5. Приложение частично покрыто тестами (будет плюсом)

**Стек**
- Kotlin
- MVVM (ViewModel + LiveData/Flow)
- Kotlin Coroutines/RxJava (будет плюсом)
- Retrofit 2
- Glide/Picasso для загрузки фото
- Clean Architecture (будет плюсом)
- Dagger 2/Hilt (будет плюсом)

**API**

В качестве API для получения данных пользователя использовать
https://randomuser.me/api/

**Дизайн**

Решения о дизайне остаются полностью на ваше усмотрение, но соблюдение
требований Material Design по каждому применённому элементу или паттерну будет
плюсом.

**Оценивается**

- Аккуратность ведения гита: именование коммитов, веток
- Реализация приложения
- Code-style: безопасный код (не приводящий к падению), правильные отступы,
отсутствие ошибок в словах, никаких “магических чисел”

# ENG
## Test task
It is necessary to implement a small Android application that displays fake
user data.
The result should be posted on github in the public domain

**Application Requirements**

1. Profile screen display: photo, full name, date of birth, phone number,
country, city, street, coordinates
2. Ability to navigate by phone number and coordinates to standard
system apps (will be a plus)
3. Ability to update data on the screen
4. Storing data in the database through Room (will be a plus)
5. The application is partially covered with tests (will be a plus)

**Stack**
- Kotlin
- MVVM (ViewModel + LiveData/Flow)
- Kotlin Coroutines/RxJava (will be a plus)
- Retrofit 2
- Glide/Picasso to upload photo
- Clean Architecture (will be a plus)
- Dagger 2/Hilt (will be a plus)

**API**

As an API to get user data use
https://randomuser.me/api/

**Design**

Design decisions are entirely up to you, but compliance
Material Design requirements for each applied element or pattern will be
a plus.

**Estimated**

- Accuracy of maintaining a git: naming commits, branches
- Application implementation
- Code-style: safe code (not crashing), proper indentation,
no misspellings, no “magic numbers”
