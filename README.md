
#### Coding challenge, JPM Chase

###### by Anil Kalavagattu (https://www.linkedin.com/in/anil-kalavagattu)


#### App functionality
1. Shows list of NYC High Schools sourced from network API
2. On selecting a school, in a separate screen show SAT scores for the school.
3. Also includes contact info, email and phone that are clickable.



#### Architecture components and corresponding code structure


Note: The following architecture diagram is from this [tutorial](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-4-saving-user-data/lesson-10-storing-data-with-room/10-1-c-room-livedata-viewmodel/10-1-c-room-livedata-viewmodel.html) that is a very good reference to learn basics of the new architecture patterns.

| ![Screen Shot 2022-11-29 at 12 31 41 PM](https://user-images.githubusercontent.com/1905832/204641483-b747f067-5199-4a32-a22f-abc393f74558.png) | ![Screen Shot 2022-11-29 at 11 55 42 AM](https://user-images.githubusercontent.com/1905832/204634801-eb626387-9951-49ae-ae9f-f6cec71e9cb7.png) | 



On the right is the code structure to show modularity best practices to keep things isolated and have minimal complexity per component. Implementation and reasoning is as follows.

1. UI / View
   * Interacts with simple data objects and View Models
2. Model
   * Data objects holding properties to set on views with minimal processing
3. ViewModel
   * Bridge between data sources and Views
   * Data source is conveniently abstracted in `Repository` 

Further, the code is split by features to further isolate unrelated code. For this app, network calls using OkHttp library, DB and data observers using Room and LiveData (part of Android Jetpack) are used. 


More feature ideas but less important for this initial challenge
1. Network loading states, 2. Visually pleasing UI, 3. Search functionality, 4. Offline functionality etc.

Note on tests:
Haven't added them for the time being and can iterate on the feedback I receive. Thanks!







#### Screenshots
| ![School List](https://user-images.githubusercontent.com/1905832/204622126-ca15fefe-e780-4381-b0dc-a82fd311adf2.png) | ![School Info](https://user-images.githubusercontent.com/1905832/204622128-55af8876-fa56-4c25-bf02-6ccedaea6688.png) | 
