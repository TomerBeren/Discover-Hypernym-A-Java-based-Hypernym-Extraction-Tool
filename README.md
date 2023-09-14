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

Contribution
This is a course assignment and is not open for contribution.

License
This project is for educational purposes and is not licensed.
