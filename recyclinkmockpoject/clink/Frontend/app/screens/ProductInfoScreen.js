import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  Image,
  StyleSheet,
  TouchableOpacity,
  TextInput,
  ScrollView,
} from "react-native";
import axios from "axios";

const ProductInfoScreen = ({ route }) => {
  const { id } = route.params;
  const [product, setProduct] = useState(null);
  const [error, setError] = useState(null);
  const [newReview, setNewReview] = useState("");
  const [quantity, setQuantity] = useState(1);
  const [imageLoadError, setImageLoadError] = useState(false);

  useEffect(() => {
    fetchProduct();
  }, [id]);

  const fetchProduct = async () => {
    try {
      const response = await axios.get(`http://10.0.2.2:3001/listings/${id}`);
      console.log("API response:", JSON.stringify(response.data, null, 2));
      setProduct(response.data);
      setError(null);
    } catch (error) {
      console.error("API error:", error);
      setError(error.message);
    }
  };

  const handleReviewChange = (text) => {
    setNewReview(text);
  };

  const incrementQuantity = () => {
    setQuantity((prevQuantity) => prevQuantity + 1);
  };

  const decrementQuantity = () => {
    setQuantity((prevQuantity) => (prevQuantity > 1 ? prevQuantity - 1 : 1));
  };

  if (error) {
    return (
      <View style={styles.container}>
        <Text style={styles.error}>{error}</Text>
      </View>
    );
  }

  if (!product) {
    return (
      <View style={styles.container}>
        <Text>Loading...</Text>
      </View>
    );
  }

  const hardcodedImageUrl = "https://recyclinktestbucket.s3.us-east-1.amazonaws.com/1721040081348.png";

  return (
    <ScrollView style={styles.container}>
      {product.imageurl ? (
        <Image
          source={{ uri: product.imageurl }}
          style={styles.productImage}
          resizeMode="contain"
          onLoadStart={() => console.log("Image load started")}
          onLoad={() => console.log("Image loaded successfully")}
          onError={(e) => {
            console.error("Image load error:", e.nativeEvent.error);
            console.log("Attempted image URL:", product.imageurl);
            setImageLoadError(true);
          }}
        />
      ) : (
        <View style={[styles.productImage, { backgroundColor: '#f0f0f0', justifyContent: 'center', alignItems: 'center' }]}>
          <Text>No image available</Text>
        </View>
      )}
      {imageLoadError && (
        <Image
          source={{ uri: hardcodedImageUrl }}
          style={styles.productImage}
          resizeMode="contain"
          onLoadStart={() => console.log("Hardcoded image load started")}
          onLoad={() => console.log("Hardcoded image loaded successfully")}
          onError={(e) => {
            console.error("Hardcoded image load error:", e.nativeEvent.error);
          }}
        />
      )}
      {imageLoadError && (
        <Text style={styles.error}>Failed to load image. URL: {product.imageurl}</Text>
      )}

      <Text style={styles.productName}>
        {product.productname || "Unknown Product"}
      </Text>
      <View style={styles.quantityContainer}>
        <TouchableOpacity
          style={styles.quantityButton}
          onPress={decrementQuantity}
        >
          <Text style={styles.quantityButtonText}>-</Text>
        </TouchableOpacity>
        <Text style={styles.quantityText}>{quantity}</Text>
        <TouchableOpacity
          style={styles.quantityButton}
          onPress={incrementQuantity}
        >
          <Text style={styles.quantityButtonText}>+</Text>
        </TouchableOpacity>
      </View>
      <Text style={styles.productStock}>
        {product.stock_status === "Out of Stock" ? "Out of Stock" : "In Stock"}
      </Text>
      <View style={styles.buttonContainer}>
        <TouchableOpacity
          style={[styles.button, { backgroundColor: "#007BFF" }]}
          onPress={() =>
            console.log(
              `Added ${product.productname} to cart with quantity ${quantity}.`
            )
          }
          disabled={product.stock_status === "Out of Stock"}
        >
          <Text style={styles.buttonText}>Add to Cart</Text>
        </TouchableOpacity>
        <TouchableOpacity
          style={[styles.button, { backgroundColor: "#FFA500" }]}
          onPress={() =>
            console.log(
              `Bought ${product.productname} with quantity ${quantity}.`
            )
          }
          disabled={product.stock_status === "Out of Stock"}
        >
          <Text style={styles.buttonText}>Buy Now</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.reviewsContainer}>
        <Text style={styles.sectionTitle}>Write a Review</Text>
        <TextInput
          style={styles.reviewInput}
          value={newReview}
          onChangeText={handleReviewChange}
          placeholder="Write your review here..."
          multiline
        />
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: "#fff",
  },
  productImage: {
    width: "100%",
    height: 300,
  },
  productName: {
    fontSize: 24,
    fontWeight: "bold",
    marginVertical: 10,
    textAlign: "center",
  },
  quantityContainer: {
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
    marginVertical: 10,
  },
  quantityButton: {
    backgroundColor: "#007BFF",
    padding: 10,
    borderRadius: 5,
  },
  quantityButtonText: {
    color: "#fff",
    fontSize: 18,
  },
  quantityText: {
    fontSize: 18,
    marginHorizontal: 10,
  },
  productStock: {
    fontSize: 18,
    marginBottom: 20,
    color: "green",
    textAlign: "center",
  },
  buttonContainer: {
    flexDirection: "column",
    alignItems: "center",
    marginBottom: 20,
  },
  button: {
    width: "80%",
    backgroundColor: "#007BFF",
    padding: 15,
    borderRadius: 7,
    marginBottom: 10,
    alignItems: "center",
  },
  buttonText: {
    color: "#fff",
    fontSize: 18,
  },
  reviewsContainer: {
    marginBottom: 20,
  },
  sectionTitle: {
    fontSize: 20,
    fontWeight: "bold",
    marginBottom: 10,
    textAlign: "center",
  },
  reviewInput: {
    height: 100,
    padding: 10,
    borderWidth: 1,
    borderColor: "#ccc",
    borderRadius: 5,
    marginBottom: 10,
  },
  error: {
    color: "red",
    textAlign: "center",
  },
});

export default ProductInfoScreen;
