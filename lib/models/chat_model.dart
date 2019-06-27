class ChatModel {
  final int userId;
  final String name;
  final String message;
  final String time;
  final String avatarUrl;
  final bool status;

  ChatModel(
      {this.userId,
      this.name,
      this.message,
      this.time,
      this.avatarUrl,
      this.status});
}

List<ChatModel> chatList = [
  new ChatModel(
      userId: 1,
      name: "Google's Flutter",
      message: "Thank you!",
      time: "01:30",
      avatarUrl: "http://pngimg.com/uploads/google/google_PNG19645.png",
      status: true),
  new ChatModel(
      userId: 2,
      name: "John Doe",
      message: "How are you Ram?",
      time: "23:30",
      avatarUrl: "http://pngimg.com/uploads/giraffe/giraffe_PNG13540.png",
      status: false),
  new ChatModel(
      userId: 3,
      name: "Michal Doe",
      message: "Wassup !",
      time: "02:00",
      avatarUrl: "http://pngimg.com/uploads/leopard/leopard_PNG14838.png",
      status: false),
  new ChatModel(
      userId: 4,
      name: "Junction Guys",
      message: "I'm good!",
      time: "11:30",
      avatarUrl: "http://pngimg.com/uploads/monkey/monkey_PNG18744.png",
      status: true),
  new ChatModel(
      userId: 5,
      name: "Jimmi Clark",
      message: "Are you done with your meal?",
      time: "22:33",
      avatarUrl: "http://pngimg.com/uploads/ostrich/ostrich_PNG76974.png",
      status: false),
  new ChatModel(
      userId: 6,
      name: "Lucky Lucy",
      message: "When did you reached? Let's go movie",
      time: "09:30",
      avatarUrl: "http://pngimg.com/uploads/sparrow/sparrow_PNG40.png",
      status: false),
];
