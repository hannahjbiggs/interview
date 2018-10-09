# VCharge Pair Programming Test Interviewer Notes

This is a language-agnostic test. It is advisable to ask the candidate to bring in their own laptop with their preferred development environment set up

This repo contains a sample solution in Scala, which the interviewer might find useful to have a look at before the test.

*The candidate has up to 60 minutes.* The only materials they should be given are the [CANDIDATE_INSTRUCTIONS](CANDIDATE_INSTRUCTIONS.md).

## What we are looking for

#### Junior

A junior developer should be comfortable writing code with the language they have chosen. We’d assume that they have had a reasonable amount of experience using this language, so shouldn’t be making basic mistakes or writing unidiomatic code. We would also expect them to have an eye for detail, be able to solve problems, and to be able to focus on delivery.

At a junior level, they might work more slowly and have to iterate their ideas several times to get something working. They may not have had much exposure to writing tests or to the concepts of clean coding.

They may occasionally get stuck and need some pointers, but will be receptive to help.

They will check that they understand the requirements, and get a mostly working solution (if they haven’t finished then they probably would get it done if given another half an hour). Their finished code should be readable and understandable, although may not be structured very well. For instance, everything could be in a single class. They demonstrate idiomatic use of the language.

There may be non-existent or minimal tests, and the tests may be focussed on the wrong things. They may not consider edge cases. They don’t refactor, and leave some code smells, such as code duplication.



#### Mid

A mid level developer should be proficient in the language they use, and be knowledgeable about good coding practices. They will have to think about their approach, and may iterate on their ideas taking a few wrong turns, but they will rapidly identify when they need to change direction. They will either complete the test, or else be close to a fully working solution. They may show a lack of pragmatism and spend unnecessary time over-engineering or over-optimising their code - for instance by using generic types, or creating a bespoke data structure to optimise calculating the instability and averages of telemetry.

They will have good test coverage, but it may not be comprehensive. They will consider edge cases and write tests for them - for instance, what should happen when the first telemetry message is received, and the program requires two messages to check for instability?

The code will have structure to it, and they will demonstrate knowledge of clean coding by keeping classes and methods small, thinking about naming, and making an effort to refactor out duplicated code, although the final result may still have unclean elements. Some of their classes and methods may still have more than one defined responsibility. They will try to avoid magic numbers, and make use of well named constants. They will structure their code in a way that allows them to test that an alert is being sent.


#### Senior

A senior developer should be extremely proficient in the language they use, and have good experience with  best practices for coding. They will be focused, ask incisive questions to clarify the requirements, and instinctively know how to go about approaching the problem. They may iteratively improve their solution as they go, but are unlikely to go down any dead ends that require a change of direction. They should find this problem easy to solve, deliver a working solution, and have time to refactor and tidy up their code.

They should have comprehensive tests, which cover edge cases, and use of mocks or stubs to isolate the unit under test. The code should be extremely easy to read and understand, and structured in a way that would make additions and changes trivial to implement, such as by keeping state behind some kind of repository abstraction and using dependency injection. They don’t over-engineer or over-optimise their code - for instance, a simple list is good enough to hold the state. However, they may comment on areas which they think may be candidates for optimisation in the future. Their classes and methods will be highly cohesive, with single defined responsibilities.

As this is a pair programming test where the candidate is taking the role of the driver, they will be communicative and explain what they are doing to the navigator. They will be able to have discussions about some of their choices, for instance talking about why they chose to use mocks rather than stubs.

As a bonus, they will be very good working with their IDE, using shortcuts and IDE help to create and refactor their code.

