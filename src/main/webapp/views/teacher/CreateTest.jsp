<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MCQ Creator</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h2 class="mt-4 mb-4">MCQ Creator</h2>
  <div class="form-group">
    <label for="questionType">Select Question Type:</label>
    <select id="questionType" class="form-control" onchange="createQuestionForm()">
      <option value="mcq">Multiple Choice Question</option>
      <option value="msq">Multiple Select Question</option>
      <option value="fill">Fill in the Blanks</option>
    </select>
  </div>
  <div id="questionForm" class="mb-4"></div>
  <button class="btn btn-primary" onclick="retrieveQuestions()">Retrieve Questions</button>
  <div id="output" class="mt-4"></div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script >
    function createQuestionForm() {
  const questionType = document.getElementById('questionType').value;
  const questionForm = document.getElementById('questionForm');
  questionForm.innerHTML = '';

  if (questionType === 'mcq') {
    questionForm.innerHTML = `
      <input type="text" class="form-control mb-2" placeholder="Enter Question">
      <input type="text" class="form-control mb-2" placeholder="Option 1">
      <input type="text" class="form-control mb-2" placeholder="Option 2">
      <input type="text" class="form-control mb-2" placeholder="Option 3">
      <input type="text" class="form-control mb-2" placeholder="Option 4">
      <input type="text" class="form-control mb-2" placeholder="Correct Answer">
    `;
  } else if (questionType === 'msq') {
    questionForm.innerHTML = `
      <input type="text" class="form-control mb-2" placeholder="Enter Question">
      <input type="text" class="form-control mb-2" placeholder="Option 1">
      <input type="text" class="form-control mb-2" placeholder="Option 2">
      <input type="text" class="form-control mb-2" placeholder="Option 3">
      <input type="text" class="form-control mb-2" placeholder="Option 4">
      <p class="mt-2">Select multiple correct answers:</p>
      <div class="form-check mb-2">
        <input class="form-check-input" type="checkbox" value="" id="option1">
        <label class="form-check-label" for="option1">Option 1</label>
      </div>
      <div class="form-check mb-2">
        <input class="form-check-input" type="checkbox" value="" id="option2">
        <label class="form-check-label" for="option2">Option 2</label>
      </div>
      <div class="form-check mb-2">
        <input class="form-check-input" type="checkbox" value="" id="option3">
        <label class="form-check-label" for="option3">Option 3</label>
      </div>
      <div class="form-check mb-2">
        <input class="form-check-input" type="checkbox" value="" id="option4">
        <label class="form-check-label" for="option4">Option 4</label>
      </div>
    `;
  } else if (questionType === 'fill') {
    questionForm.innerHTML = `
      <input type="text" class="form-control mb-2" placeholder="Enter Question">
      <input type="text" class="form-control mb-2" placeholder="Option 1">
      <input type="text" class="form-control mb-2" placeholder="Correct Answer">
    `;
  }
}

function retrieveQuestions() {
  const questions = [];
  const questionType = document.getElementById('questionType').value;
  const questionForms = document.querySelectorAll('#questionForm input[type="text"]');
  const questionText = [questionForms[0].value];
  let questionOptions = [];
  let correctAnswers = [];

  if (questionType === 'msq') {
    const options = document.querySelectorAll('#questionForm input[type="text"]');
    questionOptions = Array.from(options).slice(1, 5).map(input => input.value);
    const checkboxes = document.querySelectorAll('#questionForm input[type="checkbox"]');
    correctAnswers = Array.from(checkboxes).filter(checkbox => checkbox.checked).map(checkbox => checkbox.nextElementSibling.value);
  } else {
    questionOptions = Array.from(questionForms).slice(1, 5).map(input => input.value);
    correctAnswers = [questionForms[5].value];
  }

  questions.push(questionText, questionOptions, correctAnswers);
  console.log(questions);
}





</script>
</body>
</html>
