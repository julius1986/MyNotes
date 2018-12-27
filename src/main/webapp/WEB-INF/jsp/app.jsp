<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	
	<div id="app">
	<div>
	<input type="text" v-model = "newNote.note" @keyup.enter="addNewNote()"> <button @click="addNewNote()">add</button>
	</div>

	<div v-for="note in notes" @click="deleteNote(note)">
	{{note}}
	</div>
	</div>
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/vue"></script>
	<script src="build.js"></script>
</body>
</html>