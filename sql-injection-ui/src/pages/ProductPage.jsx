import { useCallback, useEffect, useState } from "react";
import { useParams } from "react-router-dom"

export default function ProductPage() {

  const params = useParams();
  const id = params.id;
  const [user] = useState(JSON.parse(sessionStorage.getItem("user")));
  const [product, setProduct] = useState(null);

  const fetchData = useCallback(async () => {
    const response = await fetch(process.env.REACT_APP_BASE_URL + "/products/" + id)
    const data = await response.json();
    setProduct(data)
  },[id])

  useEffect(() => {
    fetchData();
  },[fetchData])

  console.log(id);

  return (
    <div className="p-5">
      {product &&
      <>
      <h2>{product.name}</h2>
      <p>{product.description}</p>
      <p>{product.price} $</p>
      </>
      }
    </div>
  )
}
