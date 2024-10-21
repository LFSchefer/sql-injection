import { useState } from "react"
import ProductCard from '../components/ProductCard.jsx'

export default function Products() {

  const [products, setProducts] = useState([]);

  useState(async () => {
    async function fetchData() {
      const response = await fetch(process.env.REACT_APP_BASE_URL + "/products");
      const data = await response.json();
      return data;
    }
    setProducts(await fetchData());
  },[])

  return (
    <div>
      <h1>products</h1>
      <div className="product-container container">
        {products.map( p => {
          return < ProductCard key={p.id} product={p} />
        })}
      </div>
    </div>
  )

}
