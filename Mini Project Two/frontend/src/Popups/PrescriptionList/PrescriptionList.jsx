import React,{useState,useEffect} from 'react'
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import "./PrescriptionList.css"
import { MdClose } from 'react-icons/md';

const PrescriptionList = ({showPricribedList,setShowpriscribedList,prescriptionList,handleAccept}) => {
  const [medications, setMedications] = useState(prescriptionList);
  
  useEffect(() => {
    setMedications(prescriptionList);
  }, [prescriptionList]);

  const handleCheckboxChange = (index) => {
    const updatedMedications = [...medications];
    updatedMedications[index].checked = !updatedMedications[index].checked;
    setMedications(updatedMedications);
  };

  const handleQuantityChange = (index, value) => {
    const updatedMedications = [...medications];
    if (value >= 0 && value <= prescriptionList[index]?.quantity) {
      updatedMedications[index].quantity = Number(value);
      setMedications(updatedMedications);
    }
  };

  const increaseQuantity = (index) => {
    const updatedMedications = [...medications];
    updatedMedications[index].quantity += 1;
    setMedications(updatedMedications);
  };

  const decreaseQuantity = (index) => {
    const updatedMedications = [...medications];
    if (updatedMedications[index].quantity > 0) {
      updatedMedications[index].quantity -= 1;
      setMedications(updatedMedications);
    }
  };

  
  return (
    <Modal show={showPricribedList}  centered >
       
      <div className="prescription-checklist">
       
      <table className="prescription-table">
        <thead>
          <tr>
            <th>Check</th>
            <th>Name</th>
            <th>Dosage</th>
            <th>Frequency</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total Price</th>
          </tr>
        </thead>
        <tbody>
          {medications?.map((medication, index) => (
            <tr key={medication?.id}>
              <td>
                <input
                  type="checkbox"
                  checked={medication?.checked}
                  onChange={() => handleCheckboxChange(index)}
                />
              </td>
              <td>{medication?.name}</td>
              <td>{medication?.dosage}</td>
              <td>{medication?.frequency}</td>
              <td>
                <button onClick={() => decreaseQuantity(index)}>-</button>
                <input
                  type="number"
                  value={medication.quantity}
                  min={1}
                  max={prescriptionList[index]?.quantity}
                  onChange={(e) => handleQuantityChange(index, e.target.value)}
                />
                <button onClick={(e) => increaseQuantity(index)}>+</button>
              </td>
              <td>{medication?.price}</td>
              <td>{medication?.price * medication?.quantity}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div style={{display:'flex',flexDirection:'row', width:'fit-content',gap:'2vh',marginTop:'2vh'}}>
        <button className='prescription_cancel_btn' onClick={() => setShowpriscribedList(false)}>Cancel</button>
        <button className='prescription_accept_btn' onClick={() => handleAccept(medications)}>Accept</button>
      </div>
      </div>
    </Modal>
  )
}

export default PrescriptionList