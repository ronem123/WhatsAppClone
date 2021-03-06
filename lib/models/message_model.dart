class MessageModel {
  final String message;
  final bool readStatus;
  final String time;
  final bool isMe;

  MessageModel({this.message, this.readStatus, this.time, this.isMe});

  Map<String, String> toMap() => {
        "message": message,
        "readStatus": readStatus?"1":"0",
        "time": time,
        "isMe": isMe?"1":"0"
      };
}

List<MessageModel> messageList = [
  new MessageModel(
      message: "Hello Ram how are you?",
      readStatus: true,
      time: "10:00 am",
      isMe: false),
  new MessageModel(
      message: "Ke cha yaar timro khabar? ke gardai chau hijo aaja?",
      readStatus: true,
      time: "10:01 am",
      isMe: false),
  new MessageModel(
      message: "Hello! I am fine what about you ?",
      readStatus: false,
      time: "10:00 am",
      isMe: true),
  new MessageModel(
      message: "Euta kaam aaeko cha flutter ma garne ho ? Ramro pay cha",
      readStatus: true,
      time: "10:00 am",
      isMe: true),
  new MessageModel(
      message: "Eah eah huncha garam na milera kasto project ho?",
      readStatus: true,
      time: "10:00 am",
      isMe: false),
  new MessageModel(
      message: "Project ta ramro cha",
      readStatus: true,
      time: "10:00 am",
      isMe: true),
  new MessageModel(
      message: "Alexa suneko cha? Alexa assistant google ko?",
      readStatus: true,
      time: "10:00 am",
      isMe: true),
  new MessageModel(
      message: "khai kata kata sune jasto laageko cha",
      readStatus: true,
      time: "10:00 am",
      isMe: false),
  new MessageModel(
      message: "Google ko speech recognize garera kaam gardine",
      readStatus: true,
      time: "10:00 am",
      isMe: true)
];
