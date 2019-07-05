import 'package:flutter/material.dart';
import 'package:toast/toast.dart';
import '../models/chat_model.dart';
import '../models/message_model.dart';
import '../view/bubble_view.dart';
import 'package:intl/intl.dart';

class ChatScreenDetail extends StatefulWidget {
  final ChatModel chatModel;

  ChatScreenDetail({this.chatModel});

  @override
  _ChatScreenDetailState createState() => _ChatScreenDetailState(chatModel);
}

class _ChatScreenDetailState extends State<ChatScreenDetail> {
  ChatModel chatModel;
  BuildContext context;
  List<MessageModel> messages = messageList;

  TextEditingController textEditController;
  ScrollController scrollController;

  _ChatScreenDetailState(this.chatModel);

  @override
  initState() {
    super.initState();
    textEditController = new TextEditingController();
    scrollController = new ScrollController();
  }

  @override
  dispose() {
    textEditController.dispose();
    scrollController.dispose();
    super.dispose();
  }

  addMessage() {
    setState(() {
      String msg = textEditController.text;
      DateTime now = DateTime.now();
      String currentDate = DateFormat('kk:mm a').format(now);
      messages.add(new MessageModel(
          message: msg,
          readStatus: true,
          time: currentDate,
          isMe: msg.startsWith("me") ? true : false));
      scrollDown();
      textEditController.text = "";
    });
  }

  scrollDown() {
    scrollController.animateTo(scrollController.position.maxScrollExtent,
        duration: Duration(milliseconds: 100), curve: Curves.easeOut);
  }

  @override
  Widget build(BuildContext context) {
    this.context = context;
    return Scaffold(
      appBar: AppBar(
        title: new Row(
          children: <Widget>[
            CircleAvatar(
              backgroundImage: NetworkImage(chatModel.avatarUrl),
              foregroundColor: Theme.of(context).primaryColor,
            ),
            Padding(padding: const EdgeInsets.symmetric(horizontal: 5.0)),
            Container(
              padding: const EdgeInsets.only(top: 12),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    chatModel.name,
                    style:
                        TextStyle(fontWeight: FontWeight.bold, fontSize: 16.0),
                  ),
                  Text(
                    chatModel.status == true ? "Online" : "",
                    style: TextStyle(
                        fontWeight: FontWeight.normal,
                        fontSize: 14.0,
                        color: Colors.white70),
                  )
                ],
              ),
            )
          ],
        ),
        elevation: 2.3,
        actions: <Widget>[
          Icon(Icons.videocam),
          Padding(padding: const EdgeInsets.symmetric(horizontal: 10.0)),
          Icon(Icons.call),
          Padding(padding: const EdgeInsets.symmetric(horizontal: 10.0)),
          Icon(Icons.more_vert)
        ],
      ),
      body: loadBody(),
    );
  }

  Widget loadBody() {
    return Container(
      color: Colors.black12,
      child: Container(
        decoration: new BoxDecoration(
            image: DecorationImage(
                image: AssetImage("assets/images/bg.png"), fit: BoxFit.cover)),
        child: Stack(
          children: <Widget>[
            Align(alignment: Alignment.center, child: getChatList()),
            Align(alignment: Alignment.bottomCenter, child: getMessageBoxView())
          ],
        ),
      ),
    );
  }

  Widget getChatList() {
    return Container(
      padding: EdgeInsets.fromLTRB(5, 5, 5, 70),
      child: new ListView.builder(
          controller: scrollController,
          itemCount: messages.length,
          padding: EdgeInsets.symmetric(vertical: 5),
          itemBuilder: (context, i) => Bubble(
                messageModel: messages[i],
              )),
    );
  }

  Widget getMessageBoxView() {
    return Container(
      child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Row(
            children: <Widget>[
              Flexible(
                  child: new TextField(
                      controller: textEditController,
                      decoration: new InputDecoration(
                          prefixIcon: new Icon(Icons.insert_emoticon,
                              color: Colors.grey),
                          hintText: "Type a message",
                          suffixIcon: new Icon(
                            Icons.camera_alt,
                            color: Colors.grey,
                          ),
                          enabledBorder: OutlineInputBorder(
                            borderRadius:
                                BorderRadius.all(Radius.circular(30.0)),
                            borderSide:
                                BorderSide(width: 0.1, color: Colors.green),
                          ),
                          border: OutlineInputBorder(
                            borderRadius: const BorderRadius.all(
                                const Radius.circular(30.0)),
                            borderSide: BorderSide(
                                width: 0.1, color: Color(0xff057569)),
                          ),
                          fillColor: Colors.white,
                          filled: true))),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: GestureDetector(
                  onTap: () {
                    addMessage();
                  },
                  child: Container(
                    height: 60,
                    width: 60,
                    decoration: BoxDecoration(
                        color: Color(0xff057569), shape: BoxShape.circle),
                    padding: EdgeInsets.all(18),
                    child: Image.asset(
                      "assets/images/send.png",
                      color: Colors.white,
                    ),
                  ),
                ),
              )
            ],
          )),
    );
  }

  void showMessage(String msg) {
//    Navigator.pushNamed(context, '/calling');
    Toast.show(msg, context,
        duration: Toast.LENGTH_SHORT, gravity: Toast.BOTTOM);
  }
}

//class Bubble extends StatelessWidget {
//  final MessageModel messageModel;
//
//  Bubble({this.messageModel});
//
//  @override
//  Widget build(BuildContext context) {
//    final bg = messageModel.isMe ? Colors.greenAccent.shade100 : Colors.white;
//    final align =
//        messageModel.isMe ? CrossAxisAlignment.end : CrossAxisAlignment.start;
//    final icon = messageModel.readStatus ? Icons.done_all : Icons.done;
//    final radius = messageModel.isMe
//        ? BorderRadius.only(
//            topLeft: Radius.circular(5.0),
//            bottomLeft: Radius.circular(5.0),
//            bottomRight: Radius.circular(10.0),
//          )
//        : BorderRadius.only(
//            topRight: Radius.circular(5.0),
//            bottomLeft: Radius.circular(10.0),
//            bottomRight: Radius.circular(5.0),
//          );
//    final itemMargin = messageModel.isMe
//        ? const EdgeInsets.fromLTRB(100, 3, 3, 3)
//        : const EdgeInsets.fromLTRB(3, 3, 100, 3);
//    return Column(
//      crossAxisAlignment: align,
//      children: <Widget>[
//        Container(
//          margin: itemMargin,
//          padding: const EdgeInsets.all(8.0),
//          decoration: BoxDecoration(
//            boxShadow: [
//              BoxShadow(
//                  blurRadius: .5,
//                  spreadRadius: 1.0,
//                  color: Colors.black.withOpacity(.12))
//            ],
//            color: bg,
//            borderRadius: radius,
//          ),
//          child: Stack(
//            children: <Widget>[
//              Padding(
//                padding: EdgeInsets.only(right: 90.0),
//                child: Text(messageModel.message),
//              ),
//              Positioned(
//                bottom: 0.0,
//                right: 0.0,
//                child: Row(
//                  children: <Widget>[
//                    Text(messageModel.time,
//                        style: TextStyle(
//                          color: Colors.black38,
//                          fontSize: 10.0,
//                        )),
//                    Icon(
//                      icon,
//                      size: 12.0,
//                      color: Colors.black38,
//                    )
//                  ],
//                ),
//              )
//            ],
//          ),
//        )
//      ],
//    );
//  }
//}

//  Widget getChatList() {
//    return Container(
//      padding: EdgeInsets.only(bottom: 70),
//      child: new ListView.builder(
//          itemCount: messageList.length,
//          padding: EdgeInsets.symmetric(vertical: 5),
//          itemBuilder: (context, i) => Card(
//                child: ListTile(
//                  title: new Text(messageList[i].message),
//                  subtitle: Row(
//                    mainAxisAlignment: MainAxisAlignment.end,
//                    children: <Widget>[
//                      Text(messageList[i].time,
//                          style: TextStyle(
//                              fontSize: 15,
//                              color: Colors.black54,
//                              fontWeight: FontWeight.normal)),
//                      Padding(
//                        padding: const EdgeInsets.symmetric(horizontal: 5),
//                      ),
//                      Image.asset(
//                        "assets/images/call.png",
//                        height: 15,
//                        width: 15,
//                      )
//                    ],
//                  ),
//                ),
//              )),
//    );
//  }
