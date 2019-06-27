import 'package:flutter/material.dart';

import '../models/chat_model.dart';
import '../models/message_model.dart';

class ChatScreenDetail extends StatefulWidget {
  final ChatModel chatModel;

  ChatScreenDetail({this.chatModel});

  @override
  _ChatScreenDetailState createState() => _ChatScreenDetailState(chatModel);
}

class _ChatScreenDetailState extends State<ChatScreenDetail> {
  ChatModel chatModel;

  _ChatScreenDetailState(this.chatModel);

  @override
  Widget build(BuildContext context) {
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
                image: AssetImage("assets/images/bg.jpg"), fit: BoxFit.cover)),
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
      child: new ListView.builder(
          itemCount: messageList.length,
          padding: EdgeInsets.symmetric(vertical: 19),
          itemBuilder: (context, i) => Container(
                decoration: BoxDecoration(
                    image: DecorationImage(
                        image: AssetImage("assets/images/bg.jpg"),fit: BoxFit.cover)),
                child: ListTile(
                  title: new Text(messageList[i].message),
                  subtitle: new Row(
                    children: <Widget>[
                      Text(messageList[i].time,
                          style: TextStyle(
                              fontSize: 15,
                              color: Colors.black54,
                              fontWeight: FontWeight.normal)),
                      Padding(
                        padding: const EdgeInsets.symmetric(horizontal: 5),
                      ),
                      Image.asset(
                        "assets/images/call.png",
                        height: 15,
                        width: 15,
                      )
                    ],
                  ),
                ),
              )),
    );
  }

  Widget getMessageBoxView() {
    return Container(
      height: 50.0,
      color: Colors.grey,
    );
  }
}
