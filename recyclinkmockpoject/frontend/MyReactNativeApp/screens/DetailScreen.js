// screens/DetailScreen.js

import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

const DetailScreen = ({ route }) => {
  const { item } = route.params;

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Detail Screen</Text>
      <Text>List ID: {item.listid}</Text>
      <Text>Product Name: {item.productname}</Text>
      <Text>Quantity: {item.quantity}</Text>
      <Text>Approved: {item.approved ? 'Yes' : 'No'}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
  },
  title: {
    fontSize: 24,
    marginBottom: 20,
  },
});

export default DetailScreen;
