package org.example

import Address
import Company
import Education
import Person
import SocialMedia
import com.google.gson.Gson
import kotlin.system.measureTimeMillis

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

fun main() {

    // Initialize Gson instance
    val gson = Gson()

    // Number of repetitions for averaging
    val repetitions = 10_000

    // Variables to accumulate time
    var totalJsonSerializationTime = 0L
    var totalJsonDeserializationTime = 0L
    var totalProtobufSerializationTime = 0L
    var totalProtobufDeserializationTime = 0L

    // Run the test multiple times to get an average time
    repeat(repetitions) {
        // JSON serialization and deserialization
        val json = gson.toJson(person)
        val personFromJson: Person = gson.fromJson(json, Person::class.java)

        // Protobuf serialization and deserialization (using an assumed Protobuf-generated class)
        val personProto = Person.Builder()
            .name(person.name)
            .age(person.age)
            .email(person.email)
            .address(person.address)
            .companies(person.companies)
            .phone_numbers(person.phone_numbers)
            .build()

        val personBytes = personProto.encode()

        // Measure JSON serialization time
        totalJsonSerializationTime += measureTimeMillis {
            gson.toJson(person)
        }

        // Measure JSON deserialization time
        totalJsonDeserializationTime += measureTimeMillis {
            gson.fromJson(json, Person::class.java)
        }

        // Measure Protobuf serialization time
        totalProtobufSerializationTime += measureTimeMillis {
            personProto.encode()
        }

        // Measure Protobuf deserialization time
        totalProtobufDeserializationTime += measureTimeMillis {
            Person.ADAPTER.decode(personBytes)
        }
    }

    println("Total JSON Serialization time: $totalJsonSerializationTime ms")
    println("Total JSON Deserialization time: $totalJsonDeserializationTime ms")
    println("Total Protobuf Serialization time: $totalProtobufSerializationTime ms")
    println("Total Protobuf Deserialization time: $totalProtobufDeserializationTime ms")

  /*  // Calculate averages
    val averageJsonSerializationTime = totalJsonSerializationTime / repetitions
    val averageJsonDeserializationTime = totalJsonDeserializationTime / repetitions
    val averageProtobufSerializationTime = totalProtobufSerializationTime / repetitions
    val averageProtobufDeserializationTime = totalProtobufDeserializationTime / repetitions

    *//* // Print out the average times
     println("Average JSON Serialization time: $averageJsonSerializationTime ms")
     println("Average JSON Deserialization time: $averageJsonDeserializationTime ms")
     println("Average Protobuf Serialization time: $averageProtobufSerializationTime ms")
     println("Average Protobuf Deserialization time: $averageProtobufDeserializationTime ms")*/
}