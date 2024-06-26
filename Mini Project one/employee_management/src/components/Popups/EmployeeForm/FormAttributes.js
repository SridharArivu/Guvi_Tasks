export const empID_First_and_LastName = [
    { label: "Employee ID:", type: "tel", name: "employeeID", id: "employeeID", autoComplete: "off",maxLength:"8" },
    { label: "First Name", type: "text", name: "firstName", id: "firstName", autoComplete: "off",maxLength:"10" },
    { label: "Last Name", type: "text", name: "lastName", id: "lastName", autoComplete: "off",maxLength:"8" }
];
export const email_phone_and_photo = [
    { label: "Email",className:"input_field", type: "text", name: "email", id: "email", value:"email", autoComplete: "off" },
    { label: "Phone",className:"input_field", type: "tel", name: "phone", id: "phone", value:"phone", autoComplete: "off" , maxLength:"10"},
];
export const gender_and_role = [
    { label: "Role", name: "role", id: "role",
      options: [ 
        { value: "UI/UX Designer", label: "UI/UX Designer" }, 
        { value: "Software Engineer", label: "Software Engineer" },
        { value: "Product Manager", label: "Product Manager" },
        { value: "Data Scientist", label: "Data Scientist" },
        { value: "System Administrator", label: "System Administrator" }]
    },
    { label: "Gender", name: "gender", id: "gender",
      options: [ 
        { value: "Male", label: "Male" }, 
        { value: "Female", label: "Female" }, 
        { value: "Others", label: "Others" }]
    }
  ];
  
export const City_and_state = [
    { label: "City", type: "text", name: "city", id: "city", autoComplete: "off" },
    { label: "State", type: "text", name: "state", id: "state", autoComplete: "off" },
];
export const Country_and_zipcode = [
    { label: "Country", type: "text", name: "country", id: "country", autoComplete: "off" },
    { label: "ZIP Code", type: "tel", name: "pincode", id: "pincode", autoComplete: "off",maxLength:"6" },
];