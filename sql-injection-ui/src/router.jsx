import { createBrowserRouter } from "react-router-dom";
import Login from "./pages/Login";
import Products from "./pages/Products";
import ProductPage from "./pages/ProductPage";

export const router = createBrowserRouter ([
  {
    path: "/",
    element: < Login />,
  },
  {
    path: "/products",
    element: < Products />,
  },
  {
    path: "/products/:id",
    element: < ProductPage />,
  },
])
