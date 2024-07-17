import React, { useState, useEffect } from "react";
import {
  View,
  Text,
  StyleSheet,
  TouchableOpacity,
  TextInput,
  ScrollView,
  Image,
} from "react-native";
import axios from "axios";
import { useNavigation } from "@react-navigation/native";

const SearchScreen = ({ route }) => {
  const { query } = route.params;
  const [results, setResults] = useState([]);
  const [error, setError] = useState(null);
  const navigation = useNavigation();

  useEffect(() => {
    axios
      .get(`https://zchl7mdv-3001.inc1.devtunnels.ms/listings?query=${query}`)
      .then((response) => {
        console.log("Search response:", response.data); // Debug: Log the search response
        setResults(response.data);
        setError(null);
      })
      .catch((error) => {
        console.error("Error searching data:", error);
        setError(error.message);
      });
  }, [query]);

  const handleProductPress = (id) => {
    navigation.navigate("ProductInfoScreen", { id });
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.searchInput}
        placeholder="Search for a product..."
        value={query}
        editable={false}
      />
      {error ? (
        <Text style={styles.error}>{error}</Text>
      ) : (
        <ScrollView contentContainerStyle={styles.listContainer}>
          {results.map((listing) => (
            <View key={listing.listid} style={styles.card}>
              <TouchableOpacity
                onPress={() => handleProductPress(listing.listid)}
              >
                <Image
                  source={{ uri: listing.image_url }}
                  style={styles.productImage}
                  resizeMode="contain"
                />
                <Text style={styles.productName}>{listing.productname}</Text>
                <Text
                  style={[
                    styles.stockStatus,
                    listing.stock_status === "Out of Stock" &&
                      styles.outOfStock,
                    listing.stock_status === "Only Few Stock Left" &&
                      styles.fewStock,
                  ]}
                >
                  {listing.stock_status}
                </Text>
              </TouchableOpacity>
              <TouchableOpacity
                style={[
                  styles.addToCartButton,
                  listing.stock_status === "Out of Stock" &&
                    styles.disabledButton,
                ]}
                onPress={() => handleAddToCart(listing)}
                disabled={listing.stock_status === "Out of Stock"}
              >
                <Text style={styles.buttonText}>Add to Cart</Text>
              </TouchableOpacity>
            </View>
          ))}
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
  searchInput: {
    marginBottom: 20,
    borderWidth: 1,
    borderColor: "#ccc",
    borderRadius: 5,
    paddingHorizontal: 10,
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
  },
  productName: {
    fontSize: 16,
    fontWeight: "bold",
    marginVertical: 10,
  },
  stockStatus: {
    fontSize: 14,
    marginBottom: 10,
  },
  outOfStock: {
    color: "red",
  },
  fewStock: {
    color: "orange",
  },
  addToCartButton: {
    backgroundColor: "#007bff",
    paddingVertical: 10,
    borderRadius: 5,
    alignItems: "center",
  },
  disabledButton: {
    backgroundColor: "#ccc",
  },
  buttonText: {
    color: "#fff",
    fontSize: 16,
  },
});

export default SearchScreen;
