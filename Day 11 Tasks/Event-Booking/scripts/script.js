
// Store Data Array in Session Storage and then 
// again Gets from Session Storage,to use it as a Temporary memory 
let storedData = JSON.parse(sessionStorage.getItem("data"));
console.log("storedData",storedData);

if (storedData === null) {
    sessionStorage.setItem("data", JSON.stringify(data));
    storedData = JSON.parse(sessionStorage.getItem("data"));
}
storedData.forEach(function(item) {
    createCard(item);
});

// Function to Create a Card Component, by using Data Array
function createCard(dataItem) {
    var cardContainer = document.getElementById("cardContainer");

    // Create a new card container for each card
    var newCardContainer = document.createElement("div");
    newCardContainer.classList.add("cardContainer");

    var card = document.createElement("div");
    card.classList.add("card");

    var eventTitle = document.createElement("h5");
    eventTitle.textContent = "Event " + dataItem.id;
    card.appendChild(eventTitle);

    var childDiv = document.createElement("div");
    childDiv.classList.add("child_div");

    var image = document.createElement("img");
    image.classList.add("event-image");
    image.src = dataItem.image;
    image.alt = "Event Image";
    childDiv.appendChild(image);

    var detailsDiv = document.createElement("div");
    detailsDiv.classList.add("details_div");

    var eventDate = document.createElement("p");
    eventDate.textContent = dataItem.date;
    detailsDiv.appendChild(eventDate);

    var seatsAvailable = document.createElement("p");
    seatsAvailable.innerHTML = "Seats <br>Available: " + dataItem.seats;
    detailsDiv.appendChild(seatsAvailable);

    // Book Now & Sold Out Button, Conditionally Rendering Based on Seats Availability 
    var bookButton = document.createElement("button");
    bookButton.classList.add( dataItem.seats <= 0 ? "inactive_btn" : "active_btn"); 
    bookButton.textContent = dataItem.seats <= 0 ? "Sold Out" :"Book Now";
    bookButton.disabled = dataItem.seats <= 0;

    // Once Clicked, Selected Card Object Data will be Stored on Session
    bookButton.addEventListener("click", function() {
        sessionStorage.setItem("Selected-event", JSON.stringify({
            "id": dataItem.id,
            "image": dataItem.image,
            "date": dataItem.date,
            "seats": dataItem.seats
        }));
        // Redirects to Booking Page, where we can get the Stored Selected data
        window.location.href = "/booking.html";
    });
    detailsDiv.appendChild(bookButton);

    childDiv.appendChild(detailsDiv);
    card.appendChild(childDiv);

    newCardContainer.appendChild(card); // Append the card to the new card container
    cardContainer.appendChild(newCardContainer); // Append the new card container to the main card container
}
