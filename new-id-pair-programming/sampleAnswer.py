import uuid

input = [{'row_id': 1, 'id': 1, 'status': "A", "prev_status_row_id": None},
		{'row_id': 2, 'id': 1, 'status': "B", "prev_status_row_id": 1},
		{'row_id': 3, 'id': 1, 'status': "C", "prev_status_row_id": 2},
		{'row_id': 4, 'id': 2, 'status': "A", "prev_status_row_id": None},
		{'row_id': 5, 'id': 2, 'status': "B", "prev_status_row_id": 4},
		{'row_id': 6, 'id': 2, 'status': "C", "prev_status_row_id": 5},
		{'row_id': 7, 'id': 2, 'status': "A", "prev_status_row_id": None},
		{'row_id': 8, 'id': 2, 'status': "B", "prev_status_row_id": 7},
		{'row_id': 9, 'id': 2, 'status': "C", "prev_status_row_id": 8}]


def returnRowId(id):
	for x in input:
		if x["row_id"] == id:
			return x

def dbStore():
	currentId = None
	newID = None
	traceTokenSection = []
	for x in range(0, len(input)):
		if "new_id" in input[x]:
			continue
		prevRowID = input[x]["prev_status_row_id"]
		if prevRowID is None:
			input[x]["new_id"] = uuid.uuid4()
		else:
			newID = None
			while newID is None:
				prevRow = returnRowId(prevRowID)
				if "new_id" not in prevRow and prevRow["prev_status_row_id"] is not None:
					prevRowID = prevRow["prev_status_row_id"]
				elif "new_id" not in prevRow and prevRow["prev_status_row_id"] is None:
					newID = uuid.uuid4()
					prevRow["new_id"] = newID
				else:
					newID = prevRow["new_id"]
			input[x]["new_id"] = newID
