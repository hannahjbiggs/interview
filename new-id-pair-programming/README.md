
# New Id

In our product we have a database of events, there are a chain of events for each single flow through the system. Historically we have allowed external teams to specify the id for each flow but now we have items in the database that share the same id but are actually 2 different flows. Each row shows the status of the current flow and a link to the previous row for this flow.

We need to assign a truly unique id to the items in the database that belong to the same flow.

 ```
 input =
[{'row_id': 1, 'id': 1, 'status': "A", "prev_status_row_id": None},
  {'row_id': 2, 'id': 1, 'status': "B", "prev_status_row_id": 1},
  {'row_id': 3, 'id': 2, 'status': "A", "prev_status_row_id": None},
  {'row_id': 4, 'id': 2, 'status': "B", "prev_status_row_id": 3},
  {'row_id': 5, 'id': 2, 'status': "A", "prev_status_row_id": None},
  {'row_id': 6, 'id': 2, 'status': "B", "prev_status_row_id": 5}]
```

```
Expected output =
[{'row_id': 1, 'id': 1, 'status': "A", "prev_status_row_id": None, “new-id”: 1},
  {'row_id': 2, 'id': 1, 'status': "B", "prev_status_row_id": 1, “new-id”: 1},
  {'row_id': 3, 'id': 2, 'status': "A", "prev_status_row_id": None, “new-id”: 2},
  {'row_id': 4, 'id': 2, 'status': "B", "prev_status_row_id": 3, “new-id”: 2},
  {'row_id': 5, 'id': 2, 'status': "A", "prev_status_row_id": None, “new-id”: 3},
  {'row_id': 6, 'id': 2, 'status': "B", "prev_status_row_id": 5, “new-id”: 3}]
```

### Extensions 
( none of these are required to ‘pass’, these would be used to determine how senior the candidate is):

* N-depth tree
* Input array is shuffled
* What to do with missing rows
* Data set is bigger than can fit in memory

## Clean and Simple code
**Novice** - Struggles to solve the problem or requires substantial help  
**Contributor** - Solves the problem  
**Expert** - Writes code that is well structured with sensible variable names, does not write an overly complex solution (too many data structures/too many loops), little duplication of logic  
**Influencer** - Write a simple solution immediately, is able to talk at length at how it could be improved with little or no prompting, is able to do the extensions with few code changes

## Technical Specialism and Breadth (Specialism)
**Novice** - Is unclear about language specific modules that could be used in the solution, writes pseudocode in a language.  
**Contributor** - Writes a neat solution that does not reinvent the wheel, is able to discuss possible improvements.  
**Expert** - Writes a concise solution that accounts for future expansion into new technologies, can talk at length about language choice and why it is a good fit.  

## Testing
**Novice** - Does not consider testing without prompting  
**Contributor** - Considers testing, either TDD or other  
**Expert** - Thinks of ways to test first and is able to define extensive test cases and risks, suggests good tools to use to test the product and writes code that is easy to mock/stub  

## Design and Code Review
**Novice** - Writes a solution with little or no planning, does not consider ease of reading by others  
**Contributor** - Has a basic plan upfront with some prompting, is able to identify possible pitfalls  
**Expert** - Always starts with a design of how the solution will be structured, communicates the plan effectively, looks for sign off early on.  

## Pairing
**Novice** - Does not communicate effectively, does not involved the interviewer in discussion.  
**Contributor** - Talks aloud while coding, explains the direction of the solution, is able to take suggestions from the interviewer and incorporate them into the solution  
**Expert** - Ensures that everyone understands the solution before beginning, splits down the work into sections, explains thought processes and direction, asks for suggestions and feedback and uses it.  
