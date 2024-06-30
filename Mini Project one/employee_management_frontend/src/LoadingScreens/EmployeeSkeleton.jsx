import React from 'react';
import './EmployeeSkeleton.css';

const EmployeeSkeleton = () => {
  return (
    <div className='Card_Wrapper skeleton'>
      <div className='front'>
        <div className='img_wrapper'>
          <div className='profilePic skeleton-circle'></div>
        </div>
        <div className='emp_details'>
          <div>
            <div className='name skeleton-text'></div>
          </div>
          <div>
            <div className='role skeleton-text'></div>
          </div>
          <div>
            <div className='email skeleton-text'></div>
          </div>
          <div>
            <div className='phone skeleton-text'></div>
          </div>
        </div>
      </div>

      <div className='back'>
        <h4>Address:</h4>
        <div className='skeleton-text'></div>
        <div className='skeleton-text'></div>
        <div className='skeleton-text'></div>

        <div className='Buttons'>
          <div className='skeleton-button'></div>
          <div className='skeleton-button'></div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeSkeleton;
