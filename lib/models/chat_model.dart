class ChatModel {
  final String name;
  final String message;
  final String time;
  final String avatarUrl;

  ChatModel({this.name, this.message, this.time, this.avatarUrl});
}

List<ChatModel> dummyData = [
  new ChatModel(
      name: "Google's Flutter",
      message: "Thank you!",
      time: "01:30",
      avatarUrl:
          "http://pngimg.com/uploads/google/google_PNG19645.png"),
  new ChatModel(
      name: "John Doe",
      message: "How are you Ram?",
      time: "23:30",
      avatarUrl:
          "http://pngimg.com/uploads/giraffe/giraffe_PNG13540.png"),
  new ChatModel(
      name: "Michal Doe",
      message: "Wassup !",
      time: "02:00",
      avatarUrl:
          "http://pngimg.com/uploads/leopard/leopard_PNG14838.png"),
  new ChatModel(
      name: "Junction Guys",
      message: "I'm good!",
      time: "11:30",
      avatarUrl:
          "http://pngimg.com/uploads/monkey/monkey_PNG18744.png"),
  new ChatModel(
      name: "Jimmi Clark",
      message: "Are you done with your meal?",
      time: "22:33",
      avatarUrl:
          "http://pngimg.com/uploads/ostrich/ostrich_PNG76974.png"),
  new ChatModel(
      name: "Lucky Lucy",
      message: "When did you reached? Let's go movie",
      time: "09:30",
      avatarUrl:
          "http://pngimg.com/uploads/sparrow/sparrow_PNG40.png"),
];
