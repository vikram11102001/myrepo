import React, { useState } from "react";
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
} from "react-native";
import axios from "axios";

const SearchInfoScreen = () => {
  const [query, setQuery] = useState("");
  const [suggestions, setSuggestions] = useState([]);
  const [results, setResults] = useState([]);

  const handleSearchChange = (text) => {
    setQuery(text);
    // Fetch search suggestions from backend or local data
    axios
      .get(`https://zchl7mdv-3001.inc1.devtunnels.ms/suggestions?query=${text}`)
      .then((response) => {
        setSuggestions(response.data);
      });
  };

  const handleSearch = () => {
    axios
      .get(`https://zchl7mdv-3001.inc1.devtunnels.ms/listings?query=${query}`)
      .then((response) => {
        setResults(response.data);
        setSuggestions([]);
      });
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.searchInput}
        placeholder="Search for a product..."
        value={query}
        onChangeText={handleSearchChange}
      />
      <TouchableOpacity style={styles.searchButton} onPress={handleSearch}>
        <Text style={styles.searchButtonText}>Search</Text>
      </TouchableOpacity>
      <ScrollView>
        {suggestions.map((suggestion, index) => (
          <TouchableOpacity key={index} onPress={() => setQuery(suggestion)}>
            <Text style={styles.suggestion}>{suggestion}</Text>
          </TouchableOpacity>
        ))}
        {results.map((result) => (
          <View key={result.listid} style={styles.result}>
            <Text>{result.productname}</Text>
            <Text>{result.stock_status}</Text>
          </View>
        ))}
      </ScrollView>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  searchInput: {
    borderWidth: 1,
    borderColor: "#ccc",
    borderRadius: 5,
    paddingHorizontal: 10,
    marginBottom: 10,
  },
  searchButton: {
    backgroundColor: "#007bff",
    paddingVertical: 10,
    borderRadius: 5,
    alignItems: "center",
    marginBottom: 20,
  },
  searchButtonText: {
    color: "#fff",
    fontSize: 16,
  },
  suggestion: {
    paddingVertical: 10,
    borderBottomWidth: 1,
    borderBottomColor: "#ccc",
  },
  result: {
    paddingVertical: 10,
    borderBottomWidth: 1,
    borderBottomColor: "#ccc",
  },
});

export default SearchInfoScreen;
