import 'package:flutter/material.dart';

class CallModel {
  final String name;
  final String dateTime;
  final String avatarImageUrl;
  final String inOutCallImageUrl;
  final String color;

  CallModel(
      {this.name,
      this.dateTime,
      this.avatarImageUrl,
      this.inOutCallImageUrl,
      this.color});
}

List<CallModel> callList = [
  new CallModel(
      name: "Google's Flutter",
      dateTime: "6 June, 10:03 pm",
      avatarImageUrl: "http://pngimg.com/uploads/google/google_PNG19645.png",
      inOutCallImageUrl: "assets/images/arrow_left_down.png",
      color: "0xff00ff00"),
  new CallModel(
      name: "John Doe",
      dateTime: "6 May, 10:03 pm",
      avatarImageUrl: "http://pngimg.com/uploads/giraffe/giraffe_PNG13540.png",
      inOutCallImageUrl: "assets/images/arrow_right_down.png",
      color: "0xffff0000"),
  new CallModel(
      name: "Google's Flutter",
      dateTime: "6 June, 09:03 pm",
      avatarImageUrl: "http://pngimg.com/uploads/google/google_PNG19645.png",
      inOutCallImageUrl: "assets/images/arrow_right_down.png",
      color: "0xffff0000"),
  new CallModel(
      name: "Junction Guys",
      dateTime: "6 April, 10:03 pm",
      avatarImageUrl: "http://pngimg.com/uploads/monkey/monkey_PNG18744.png",
      inOutCallImageUrl: "assets/images/arrow_left_down.png",
      color: "0xff00ff00")
];
