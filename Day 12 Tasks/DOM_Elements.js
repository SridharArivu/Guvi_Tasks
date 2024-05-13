import data from './data.json' with {type:'json'}
// Create the title element
const titleElement = document.createElement('h1');
titleElement.id = 'title';
titleElement.textContent = 'Pagination in DOM Manipulation';

// Create the description element
const descriptionElement = document.createElement('p');
descriptionElement.id = 'description';
descriptionElement.textContent = 'Employee Information Table';

// Create the table element
const tableElement = document.createElement('table');
tableElement.id = 'table';
tableElement.classList.add('table', 'table-bordered');

// Create the table header (thead) and table body (tbody) elements
const tableHeadElement = document.createElement('thead');
const tableBodyElement = document.createElement('tbody');

// Create the table header row (tr) and cells (th)
const tableHeaderRow = document.createElement('tr');
['S.no', 'First Name', 'Last Name','email'].forEach(headerText => {
    const headerCell = document.createElement('th');
    headerCell.textContent = headerText;
    tableHeaderRow.appendChild(headerCell);
});
tableHeadElement.appendChild(tableHeaderRow);
// Create a sample row in the table body
let serialNumber = 1;

data.forEach(item => {
    const fullName = item.name;
    const [firstName, lastName] = fullName.split(' ');

    // Create a new table row for each item in the data array
    const tableRow = document.createElement('tr');

    // Create table cells for serial number, first name, last name, and email
    const serialNumberCell = document.createElement('td');
    serialNumberCell.textContent =item.id;
    tableRow.appendChild(serialNumberCell);

    const firstNameCell = document.createElement('td');
    firstNameCell.textContent = firstName;
    tableRow.appendChild(firstNameCell);

    const lastNameCell = document.createElement('td');
    lastNameCell.textContent = lastName;
    tableRow.appendChild(lastNameCell);

    const emailCell = document.createElement('td');
    emailCell.textContent = item.email;
    tableRow.appendChild(emailCell);

    // Append the table row to the table body
    tableBodyElement.appendChild(tableRow);
});


// Append the table header and body to the table element
tableElement.appendChild(tableHeadElement);
tableElement.appendChild(tableBodyElement);

// Create the div container for table responsiveness
const tableResponsiveDiv = document.createElement('div');
tableResponsiveDiv.classList.add('table-responsive');
tableResponsiveDiv.appendChild(tableElement);


// Append all elements to the body
document.body.appendChild(titleElement);
document.body.appendChild(descriptionElement);
document.body.appendChild(tableResponsiveDiv);
