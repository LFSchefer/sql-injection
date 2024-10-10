import { useState } from "react";
import './ProductCard.css'
import { useNavigate } from "react-router-dom";

export default function ProductCard(props) {

  const [product] = useState(props.product);
  const navigate = useNavigate();

  const goToProduct = () => {
    navigate(`/products/${product.id}`)
  }

  return (
    <div className="product-card card d-flex flex-row justify-content-around col-8 p-3 m-4" onClick={goToProduct}>
      <div>
        <h5>{product.name}</h5>
        <p>{product.description}</p>
      </div>
      <p>{product.price} $</p>
    </div>
  );

}
