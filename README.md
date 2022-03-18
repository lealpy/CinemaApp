# CinemaApp
Приложение для отображения списка фильмов и просмотра информации о них. 

Все элементы главного экрана расположены в одном Recycler View.

![Screenshot](https://user-images.githubusercontent.com/90380451/158895005-b37bf636-10f2-4ef9-9958-8232fb9e5f36.png)

Код построен по принципам чистой архитектуры и шаблона MVP.
Для инъекции зависимостей применяется Dagger-Hilt.
Многопоточность реализована с помощью Coroutines.
Для интернет-запросов используются библиотеки Retrofit, OkHttp.
Изображения загружаются с помощью библиотеки Glide.
Для хранения данных в памяти устройства предусмотрена база данных, организованная с помощью библиотеки Room.
Во время работы приложения контроллируется интернет-соединение на Kotlin Flow. 
При отсутствии подключения на экране будет показано соответствующее уведомление.

## Видео работы приложения
https://user-images.githubusercontent.com/90380451/158894803-4f3e94f9-efe3-442e-a1c8-f24722d7ad29.mp4

## Стек технологий:
- Clean architecture, MVP
- Dagger-Hilt
- Navigation Component
- Coroutines
- Retrofit, OkHttp
- Glide
- Room
- RecyclerView with multiple View Types

## APK-файл:
APK находится в директории CinemaApp/app/release/app-release.apk
