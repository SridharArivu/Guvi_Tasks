import React,{useState} from 'react'
import "./PrescribeForm.css"
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import { MdClose } from "react-icons/md";

const PrescribeForm = ({showPrescribeForm,seShowtPrescribeForm,handlePrescribe,setMedicines,medicines}) => {


  const handleInputChange = (index, field, value) => {
    const updatedMedicines = [...medicines];
    updatedMedicines[index][field] = value;
    setMedicines(updatedMedicines);
  };

  const addMedicine = () => {
    const newId = medicines.length + 1;
    setMedicines([...medicines, {id:newId ,name: '', dosage: '', frequency: '',quantity:'',price:'' }]);
  };

  const removeMedicine = (index) => {
    const updatedMedicines = medicines.filter((_, i) => i !== index);
    setMedicines(updatedMedicines);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    handlePrescribe();
  };

  return (
    <Modal show={showPrescribeForm} centered>
        
    <form className="prescription-form" onSubmit={handleSubmit}>
        <MdClose className='PrescribeForm_close_icon' onClick={() =>seShowtPrescribeForm(false) }/>
      <h3>Prescription Form</h3>
      {medicines.map((medicine, index) => (
        <div key={index} className="medicine-row">
          <input
            type="text"
            placeholder="Medicine Name"
            value={medicine.name}
            onChange={(e) => handleInputChange(index, 'name', e.target.value)}
          />
          <input
            type="text"
            placeholder="Dosage"
            value={medicine.dosage}
            onChange={(e) => handleInputChange(index, 'dosage', e.target.value)}
          />
          <input
            type="text"
            placeholder="Frequency"
            value={medicine.frequency}
            onChange={(e) => handleInputChange(index, 'frequency', e.target.value)}
          />
          <input
            type="number"
            placeholder="Quantity"
            value={medicine.quantity}
            min={1} 
            onChange={(e) => handleInputChange(index, 'quantity', e.target.value)}
          />
          <input
            type="tel"
            placeholder="Price"
            value={medicine.price} 
            onChange={(e) => handleInputChange(index, 'price', e.target.value)}
          />
          <button type="button" onClick={() => removeMedicine(index)}>Remove</button>
        </div>
      ))}
      <button type="button" onClick={addMedicine} className="add-button">Add Medicine</button>
      <button type="submit" className="submit-button">Submit Prescription</button>
    </form>
    </Modal>
  )
}

export default PrescribeForm