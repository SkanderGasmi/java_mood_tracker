# Mood Tracker Console Application

![Java](https://img.shields.io/badge/Java-JDK%2025-orange)
![Console App](https://img.shields.io/badge/Application-Console-blue)

---

## Table of Contents

- [Overview](#overview)  
- [Features](#features)  
- [Functionality](#functionality)  
- [Tech Stack](#tech-stack)  
- [Setup Instructions](#setup-instructions)  
- [Why I Built This](#why-i-built-this)  
- [Future Improvements](#future-improvements)  
- [License](#license)  

---

## Overview

This is a **Java-based console application** for tracking moods.  
Users can add, edit, delete, search, and list moods with date, time, and optional notes.  
All moods can also be saved to a file for persistence.

The project demonstrates **object-oriented programming concepts**, exception handling, collections, and file I/O.

---

## Features

- Add moods with name, date, time, and notes  
- Edit mood notes  
- Delete moods by date or specific mood  
- Search moods by date or specific mood  
- View all moods  
- Save moods to a text file  
- Input validation to prevent duplicate moods

---

## Functionality

- **Add Mood**  
  User can enter mood name, optional date and time, and notes. Duplicate moods for the same date/time are not allowed.

- **Edit Mood**  
  Update notes for a specific mood by specifying name, date, and time.

- **Delete Mood**  
  - Delete all moods on a specific date  
  - Delete a single mood using name, date, and time  

- **Search Mood**  
  - Retrieve all moods for a specific date  
  - Retrieve a specific mood by name, date, and time  

- **Get All Moods**  
  Display all recorded moods in the tracker.

- **Write to File**  
  Save all moods to `moodtracker.txt` for persistence.

---

## Tech Stack

- **Java (JDK 21)**  
- Console-based input/output  
- Core Java libraries: `java.util`, `java.time`, `java.io`  

---

## Setup Instructions

1. Clone the repository:

```bash
git clone https://github.com/SkanderGasmi/java-mood-tracker.git
cd java-mood-tracker


Compile the application:

javac -d classes src\Mood.java src\InvalidMoodException.java src\MoodTracker.java


Run the program:

java -cp classes MoodTracker

Why I Built This

I built this project to practice object-oriented programming, collections, and file I/O in Java.
It provides hands-on experience with console-based user interaction, validation, and exception handling.

Future Improvements

Add persistent storage with a database

Implement a GUI interface

Enhance search functionality with partial name matching

Add unit tests for all functionalities

Include statistics and mood analytics.
