# Varo Challenge - *VaroMovieChallenge*

**VaroMovieChallenge** is an android app that uses the TMDB API to display now playing movies, ability to save and view a favorite movie.


## API key 🔑
You'll need to provide API key to fetch data from TheMovieDataBase API.

- Add API key to project
- Create new file named -> `tmdb.properties` in our project app/ folder
- Add the API key as shown below:
```
    TMDB_API_KEY=abcdexxx
```
- Build the app 🚀


## User Stories

The following **required** functionality is completed:

* [x] User can **view now playing movies** including their title, poster and description.
* [x] User can **view detail of a movie**.
* [x] User can **bookmark a favorite movie**.
* [x] User can **view favorite movie locally**.

The following **optional** features are implemented:

* [ ] Enable sorting movies by rating, release date, title, etc.
* [ ] Enable searching for movies.
* [ ] Show off some animation skills.
* [ ] Add the ability to view local showtimes.



The following **additional** features are implemented:

* [x] User can see if a movie has been bookmarked or not.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://i.imgur.com/kX0Sp7Q.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />






## Libraries and tools 🛠

VaroMovieChallenge App uses libraries and tools used to build Modern Android application, mainly part of Android Jetpack 🚀

- [Kotlin](https://kotlinlang.org/)
- [Dagger-hilt](https://dagger.dev/hilt/)🗡
- [Epoxy](https://github.com/airbnb/epoxy)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Glide](https://github.com/bumptech/glide)
- [Timber](https://github.com/JakeWharton/timber)
- [Retrofit](https://square.github.io/retrofit/)
- Architecture components
- Other [Android Jetpack](https://developer.android.com/jetpack) components


## Architecture

The app uses MVVM [Model-View-ViewModel] architecture to have a unidirectional flow of data, separation of concern, testability, and a lot more.

Read more:
- [Building Modern Android Apps with Architecture Guidelines](https://medium.com/@aky/building-modern-apps-using-the-android-architecture-guidelines-3238fff96f14)
- [Guide to app architecture](https://developer.android.com/jetpack/docs/guide)




## License

    Copyright 2021 Jephte Colin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
