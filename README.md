# Discover Hypernym: A Java-based Hypernym Extraction Tool

## Overview

This project is an implementation of a Java-based hypernym extraction tool that utilizes lexico-syntactic patterns (commonly known as Hearst Patterns) to identify hypernym relations within a large corpus of text. The project is designed as a final assignment for an Object-Oriented Programming course.

## Features

- Reads a large corpus of text files from a directory to identify possible hypernyms.
- Employs Hearst Patterns to accurately detect hypernym-hyponym relationships.
- Outputs hypernyms sorted in descending order based on their occurrence frequency.
  
## Usage

The `DiscoverHypernym` class requires two arguments:

1. Absolute path to the directory containing the corpus
2. A lemma for which you want to find possible hypernyms

The command will look like this:

```bash
java DiscoverHypernym /path/to/corpus-directory lemma
```
## Pattern Support

The following Hearst Patterns are supported:

- `NP {,} such as NP {, NP, ..., {and|or} NP}`
- `such NP as NP {, NP, ..., {and|or} NP}`
- `NP {,} including NP {, NP, ..., {and|or} NP}`
- `NP {,} especially NP {, NP, ..., {and|or} NP}`
- `NP {,} which is {{an example|a kind|a class} of} NP`

## Notes

- The corpus should be pre-processed to include `<np>` tags around noun phrases.
- The program respects OOP paradigms and follows the principles taught in the course.

## How to Run

After cloning the repository, navigate to the project root and execute:

```bash
unzip ass7.zip
ant compile
ant run
```
