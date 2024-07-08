import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  ScrollView,
  StyleSheet,
  TouchableOpacity,
} from "react-native";
import axios from "axios";

const HomeScreen = () => {
  const [listings, setListings] = useState([]);

  useEffect(() => {
    axios
      .get(
        "https://059b-2406-7400-bb-5046-a8b9-2b1f-935e-63ff.ngrok-free.app/listings"
      )
      .then((response) => {
        console.log(response.data); // Log response data
        setListings(response.data);
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  return (
    <ScrollView contentContainerStyle={styles.container}>
      {listings.map((listing) => (
        <View key={listing.listid} style={styles.card}>
          <Text style={styles.productName}>{listing.productname}</Text>
          {listing.quantity > 0 ? (
            <>
              <Text style={styles.inStock}>In Stock</Text>
              {listing.quantity < 11 && (
                <Text style={styles.fewStockLeft}>Only Few Stock Left</Text>
              )}
              <TouchableOpacity style={styles.button}>
                <Text style={styles.buttonText}>Add to Cart</Text>
              </TouchableOpacity>
            </>
          ) : (
            <>
              <Text style={styles.outOfStock}>Out of Stock</Text>
              <TouchableOpacity style={styles.fadeButton} disabled>
                <Text style={styles.fadeButtonText}>Add to Cart</Text>
              </TouchableOpacity>
            </>
          )}
        </View>
      ))}
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 20,
  },
  card: {
    backgroundColor: "#fff",
    padding: 20,
    marginBottom: 20,
    borderRadius: 10,
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 5,
    elevation: 5,
  },
  productName: {
    fontSize: 18,
    fontWeight: "bold",
    marginBottom: 10,
  },
  inStock: {
    color: "green",
    marginBottom: 10,
  },
  outOfStock: {
    color: "red",
    marginBottom: 10,
  },
  button: {
    backgroundColor: "#007bff",
    paddingVertical: 10,
    paddingHorizontal: 20,
    borderRadius: 5,
  },
  fadeButton: {
    backgroundColor: "#808080",
    paddingVertical: 10,
    paddingHorizontal: 20,
    borderRadius: 5,
  },
  buttonText: {
    color: "#fff",
    textAlign: "center",
  },
  fadeButtonText: {
    color: "#fff",
    textAlign: "center",
  },
  fewStockLeft: {
    color: "orange",
    marginBottom: 10,
  },
});

export default HomeScreen;
