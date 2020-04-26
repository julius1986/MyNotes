<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Mynotes</title>
	<link rel=icon href=/favicon.ico>
	<link href=/css/app.css rel=preload as=style>
  	<link href="/js/app.js" rel=preload as=script>
  	<link href="/js/chunk-vendors.js" rel=preload as=script>
  	<link href="/css/app.css" rel=stylesheet></head>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
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
	
	<script src="/js/chunk-vendors.js"></script>
    <script src="/js/app.js"></script>
	

</body>
</html>