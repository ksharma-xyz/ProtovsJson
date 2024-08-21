Comparing Serializing and Deserializing of 1 object of `Person` using Gson vs Protobuf

```kotlin
val person = Person(
    name = "John Doe",
    age = 30,
    email = "johndoe@example.com",
    address = Address(
        state = "ABC",
        street = "1 Station Street",
        city = "City",
        zip = "1111",
        country = "India",
        latitude = 10.00f,
        longitude = 10.00f,
    ),
    companies = listOf(
        Company(
            name = "C1",
            role = "Associate Engineer",
            employee_count = 1000,
            locations = listOf("Sydney", "Melbourne", "India"),
            metadata = mapOf("Key1" to "Value1", "key2" to "value2"),
        ),
        Company(
            name = "C2",
            role = "Engineer",
            employee_count = 1000,
            locations = listOf("Sydney", "Melbourne", "India"),
            metadata = mapOf("Key1" to "Value1", "key2" to "value2"),
        ),
        Company(
            name = "C3",
            role = "Sr. Engineer",
            employee_count = 1000,
            locations = listOf("Sydney", "Melbourne", "India"),
            metadata = mapOf("Key1" to "Value1", "key2" to "value2"),
        ),
        Company(
            name = "C4",
            role = "Sr. Engineer",
            employee_count = 1000,
            locations = listOf("Sydney", "Melbourne", "India"),
            metadata = mapOf("Key1" to "Value1", "key2" to "value2"),
        ),
    ),
    phone_numbers = listOf("05363377382", "036372882", "0372822727"),
    education = listOf(
        Education(
            school_name = "School 1",
            degree = "Computers",
            field_of_study = "Engineering",
            graduation_year = 1900,
        ),
        Education(
            school_name = "School 2",
            degree = "Science",
            field_of_study = "Engineering",
            graduation_year = 1905,
        ),
    ),
    social_media_profiles = listOf(
        SocialMedia(platform = "Fb", username = "fb123", followers_count = 10000),
        SocialMedia(platform = "insta", username = "insta1", followers_count = 10000)
    ),
    is_married = false,
    preferences = mapOf("Pre1" to "A", "Pref2" to "B")
)

```

## Following are the times takes for given repetitions

### - 10K repetitions

> Total JSON Serialization time: 105 ms
> 
> Total JSON Deserialization time: 145 ms
> 
> Total Protobuf Serialization time: 35 ms
> 
> Total Protobuf Deserialization time: 71 ms

### - 20K repetitions

> Total JSON Serialization time: 188 ms
> 
> Total JSON Deserialization time: 203 ms
> 
> Total Protobuf Serialization time: 48 ms
> 
> Total Protobuf Deserialization time: 84 ms

### - 100K repetitions

> Total JSON Serialization time: 645 ms
>
> Total JSON Deserialization time: 555 ms
>
> Total Protobuf Serialization time: 131 ms
>
> Total Protobuf Deserialization time: 323 ms


## Libraries used
- Gson
- [Wire Gradle Plugin](https://square.github.io/wire/)
