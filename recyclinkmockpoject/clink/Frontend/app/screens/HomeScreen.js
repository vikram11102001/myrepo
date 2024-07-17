import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  ScrollView,
  StyleSheet,
  TouchableOpacity,
  TextInput,
  Image,
  ActivityIndicator,
} from "react-native";
import axios from "axios";
import { useNavigation } from "@react-navigation/native";

const HomeScreen = () => {
  const [listings, setListings] = useState([]);
  const [filteredListings, setFilteredListings] = useState([]);
  const [query, setQuery] = useState("");
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);
  const navigation = useNavigation();

  const fetchListings = async () => {
    try {
      setLoading(true);
      const response = await axios.get("http://10.0.2.2:3001/listings");
      console.log("Frontend listings response:", response.data);
      setListings(response.data || []);
      setFilteredListings(response.data || []); // Initialize filtered listings
      setError(null);
    } catch (error) {
      console.error("Error fetching data:", error);
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchListings();
  }, []);

  useEffect(() => {
    if (query === "") {
      setFilteredListings(listings); // Reset to all listings if query is empty
    } else {
      const filtered = listings.filter((listing) =>
        listing.productname.toLowerCase().includes(query.toLowerCase())
      );
      setFilteredListings(filtered); // Update filtered listings
    }
  }, [query, listings]);

  const handleProductPress = (id) => {
    navigation.navigate("ProductInfoScreen", { id });
  };

  const handleAddToCart = (product) => {
    console.log(`Added ${product.productname} to cart.`);
  };

  return (
    <View style={styles.container}>
      <View style={styles.searchContainer}>
        <TextInput
          style={styles.searchInput}
          placeholder="Search for a product..."
          value={query}
          onChangeText={setQuery}
        />
        <TouchableOpacity style={styles.searchButton} onPress={() => {}}>
          <Text style={styles.searchButtonText}>Search</Text>
        </TouchableOpacity>
      </View>
      {error && <Text style={styles.error}>{error}</Text>}
      {loading ? (
        <View style={styles.loading}>
          <ActivityIndicator size="large" color="#007bff" />
        </View>
      ) : (
        <ScrollView contentContainerStyle={styles.listContainer}>
          {Array.isArray(filteredListings) && filteredListings.length > 0 ? (
            filteredListings.map((listing) => (
              <View key={listing.listingid} style={styles.card}>
                <TouchableOpacity onPress={() => handleProductPress(listing.listingid)}>
                  {listing.images.length > 0 && (
                    <Image
                      source={{ uri: listing.images[0] }}
                      style={styles.productImage}
                      resizeMode="contain"
                    />
                  )}
                  <Text style={styles.productName}>{listing.productname}</Text>
                  {listing.quantity > 0 ? (
                    <>
                      <Text style={styles.inStock}>In Stock</Text>
                      {listing.quantity < 11 && (
                        <Text style={styles.fewStockLeft}>Only Few Stock Left</Text>
                      )}
                      <TouchableOpacity
                        style={styles.addToCartButton}
                        onPress={() => handleAddToCart(listing)}
                      >
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
                </TouchableOpacity>
              </View>
            ))
          ) : (
            <Text>No listings available</Text>
          )}
        </ScrollView>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  searchContainer: {
    flexDirection: "row",
    marginBottom: 20,
  },
  searchInput: {
    flex: 1,
    borderWidth: 1,
    borderColor: "#ccc",
    borderRadius: 5,
    paddingHorizontal: 10,
  },
  searchButton: {
    marginLeft: 10,
    backgroundColor: "#007bff",
    paddingVertical: 10,
    paddingHorizontal: 20,
    borderRadius: 5,
  },
  searchButtonText: {
    color: "#fff",
    fontSize: 16,
  },
  error: {
    color: "red",
    textAlign: "center",
  },
  listContainer: {
    flexDirection: "row",
    flexWrap: "wrap",
    justifyContent: "space-between",
  },
  card: {
    width: "48%",
    marginBottom: 20,
    padding: 10,
    borderWidth: 1,
    borderColor: "#ccc",
    borderRadius: 5,
    backgroundColor: "#fff",
  },
  productImage: {
    width: "100%",
    height: 150,
    marginBottom: 10,
  },
  productName: {
    fontSize: 16,
    fontWeight: "bold",
    marginVertical: 10,
  },
  inStock: {
    color: "green",
  },
  fewStockLeft: {
    color: "orange",
  },
  outOfStock: {
    color: "red",
  },
  addToCartButton: {
    backgroundColor: "#007bff",
    paddingVertical: 10,
    borderRadius: 5,
    alignItems: "center",
  },
  fadeButton: {
    backgroundColor: "#ccc",
    paddingVertical: 10,
    borderRadius: 5,
    alignItems: "center",
  },
  fadeButtonText: {
    color: "#666",
  },
  buttonText: {
    color: "#fff",
    fontSize: 16,
  },
  loading: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
});

export default HomeScreen;