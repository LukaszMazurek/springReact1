import React, {Component, useState} from "react";


class Carlist extends Component{

    constructor(prps) {
        super(prps);
        this.state = { cars: [] }
    }

    componentDidMount() {

        fetch('http://localhost:8080/cars')
            .then(response => response.json())
            .then(responseData => this.setState({cars: responseData}))
            .catch(err => console.error(err))
    }

    render(){
        const tableRows = this.state.cars.map((car, index) =>
            <tr key={index}>
                <td>{car.brand}</td>
                <td>{car.model}</td>
                <td>{car.color}</td>
                <td>{car.year}</td>
                <td>{car.price}</td>
            </tr>
        );


        return (
            <div className="App">
                <table>
                    <tbody>{tableRows}</tbody>
                </table>
            </div>
        );
    }
}

export default Carlist