import { useState } from "react";

function App() {
  const [num1, setNum1] = useState('0');
  const [num2, setNum2] = useState('0');
  const [result, setResult] = useState('0');
  const [operation, setOperation] = useState('add');

  const handleInputChange1 = (e) => {
    setNum1(e.target.value);
  };

  const handleInputChange2 = (e) => {
    setNum2(e.target.value);
  };

  const handleOperationChange = (e) => {
    setOperation(e.target.value);
  };

  const calculate = () => {
    const n1 = parseFloat(num1);
    const n2 = parseFloat(num2);
    let calculatedResult;

    if (operation === 'add') {
      calculatedResult = n1 + n2;
    } else if (operation === 'subtract') {
      calculatedResult = n1 - n2;
    } else if (operation === 'multiply') {
      calculatedResult = n1 * n2;
    } else if (operation === 'divide') {
      if (n2 === 0) {
        calculatedResult = 'Cannot divide by zero';
      } else {
        calculatedResult = n1 / n2;
      }
    }

    setResult(calculatedResult);
  };

  return (
    <div>
      <label htmlFor="num1">Number 1</label>
      <input
        id="num1"
        type="number"
        value={num1}
        onChange={handleInputChange1}
      />

      <label htmlFor="operation">Operation</label>
      <select
        id="operation"
        value={operation}
        onChange={handleOperationChange}
      >
        <option value="add">Addition (+)</option>
        <option value="subtract">Subtraction (-)</option>
        <option value="multiply">Multiplication (×)</option>
        <option value="divide">Division (÷)</option>
      </select>

      <label htmlFor="num2">Number 2</label>
      <input
        id="num2"
        type="number"
        value={num2}
        onChange={handleInputChange2}
      />

      <button onClick={calculate}>Calculate</button>

      <h1>Result: {result}</h1>
    </div>
  );
}

export default App;