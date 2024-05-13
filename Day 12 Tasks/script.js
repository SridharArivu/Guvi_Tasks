let thisPage = 1;
let limit = 10; // Set limit to 10 rows per page
let list = document.querySelectorAll('.table-responsive table tbody tr');


// Function to Load Details based on thisPage value, filters details
function load() {
    let begin = limit * (thisPage - 1);
    let end = Math.min(limit * thisPage - 1, list.length - 1);

    list.forEach((item, key) => {
        if (key >= begin && key <= end) {
            item.style.display = 'table-row';
        } else {
            item.style.display = 'none';
        }
    });
}

// function to change the Page Number
function changePage(pageNumber) {
    thisPage = pageNumber;
    load();
    update();
}
// function to put InnerText on Buttons, based on their type
function buttonInnerText(value){
    switch(value){
        case 'First': return '<<';
        case 'Previous': return '<';
        case 'Next': return '>';
        default : return '>>';
    }
}

// Update function which is totally in control for Buttons, to Conditionally render buttons based on Page
function update(){

    let paginationButtonsDiv = document.getElementById('buttons');
    // Create Div if it is not present
    if (!paginationButtonsDiv) {
        paginationButtonsDiv = document.createElement('div');
        paginationButtonsDiv.id = 'buttons';
        paginationButtonsDiv.classList.add('d-flex', 'justify-content-center');
    } else {
        paginationButtonsDiv.innerHTML = '';
    }

let count = Math.ceil(list.length / limit);

// Create FIRST and PREVIOUS buttons
['First', 'Previous'].forEach(buttonText => {
    const button = document.createElement('button');
    button.classList.add('btn', 'btn-primary');
    button.textContent = buttonInnerText(buttonText);
    button.id = buttonText;
    if (thisPage === 1) {
        button.setAttribute('disabled', true);
        button.id = 'Disabled';
    }
    if (buttonText === 'First') {
        button.addEventListener('click', () => changePage(1));
    } else if (buttonText === 'Previous') {
        button.addEventListener('click', () => changePage(Math.max(thisPage - 1, 1)));
    }
    paginationButtonsDiv.appendChild(button);
});

// Create button for Pages
const pageListButton = document.createElement('div');
pageListButton.classList.add('buttons_list');

for (let i = 1; i <= count; i++) {
    const button = document.createElement('button');
    button.classList.add('pageBtns');
    button.innerHTML = i;
    if (i === thisPage) {
        button.classList.add('active');
    }
    button.addEventListener('click', function() {
        document.querySelectorAll('.pageBtns').forEach(btn => btn.classList.remove('active'));
        this.classList.add('active');
        changePage(i);
    });
    pageListButton.appendChild(button);
}

paginationButtonsDiv.appendChild(pageListButton);

// Create NEXT and LAST buttons
['Next', 'Last'].forEach(buttonText => {
    const button = document.createElement('button');
    button.classList.add('btn', 'btn-primary');
    button.textContent = buttonInnerText(buttonText);
    button.id = buttonText;
    if (thisPage === 10) {
        button.setAttribute('disabled', true);
        button.id = 'Disabled';
    }
    if (buttonText === 'Next') {
        button.addEventListener('click', () => changePage(Math.min(thisPage + 1, count)));
    } else if (buttonText === 'Last') {
        button.addEventListener('click', () => changePage(Math.ceil(list.length / limit)));
    }

    paginationButtonsDiv.appendChild(button);
});

document.body.appendChild(paginationButtonsDiv);
}
update();
load();
