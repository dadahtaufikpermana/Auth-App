# Auth App

The Auth App is an authentication login project that utilizes the API from https://reqres.in/. The application is built using the MVVM architecture and the Kotlin programming language.

## Features

1. **Login Form:** Users can log in by filling out a form that requests an email address and password. This data is then sent to the https://reqres.in/ API for authentication.

2. **Handle Response Code:** The application handles responses from the API, displaying error messages in the form of a snackbar if there is a login failure with a status code of 400.

3. **Login Session:** If login is successful with a status code of 200, the application will store the user's login session.

4. **User List with Pagination:** After a successful login, the application displays a list of users using pagination. Each click on the pagination button will load another 10 users.

## Technologies and Libraries Used

- [Retrofit](https://square.github.io/retrofit/): Library for accessing APIs and performing network communication.
- [ViewModel and LiveData](https://developer.android.com/jetpack/androidx/releases/lifecycle): Android architecture components for managing UI-related data in a lifecycle-conscious way.
- [Glide](https://github.com/bumptech/glide): Library for efficient loading and displaying of images.
- [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started): Android Jetpack component for handling navigation between destinations in the app.
- [JUnit](https://junit.org/junit4/): Testing framework for unit testing in Java.
- [Espresso](https://developer.android.com/training/testing/espresso): UI testing library for Android applications.

## Installation

1. Clone this repository into Android Studio or your preferred Kotlin IDE.
2. Sync the project to download the required libraries and dependencies. Ensure that the project's Gradle files are synced successfully.
3. Run the application on an emulator or a physical device that has been set up.

## Application Screenshots

![splash_screen](https://github.com/dadahtaufikpermana/Auth-App/assets/108538497/34f77823-8a95-4d09-a2d4-f765a39662bc)
![login_screen](https://github.com/dadahtaufikpermana/Auth-App/assets/108538497/5c78c675-a443-4eb1-82ae-c3c9bc5b9ac6)
![list_user_screen](https://github.com/dadahtaufikpermana/Auth-App/assets/108538497/1fdf548e-e3ba-42ad-a1b4-f99680e61906)

---
