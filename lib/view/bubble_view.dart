import 'package:flutter/material.dart';
import '../models/message_model.dart';

class Bubble extends StatelessWidget {
  final MessageModel messageModel;

  Bubble({this.messageModel});

  @override
  Widget build(BuildContext context) {
    final bg = messageModel.isMe ? Colors.greenAccent.shade100 : Colors.white;
    final align =
        messageModel.isMe ? CrossAxisAlignment.end : CrossAxisAlignment.start;
    final icon = messageModel.readStatus ? Icons.done_all : Icons.done;
    final radius = messageModel.isMe
        ? BorderRadius.only(
            topLeft: Radius.circular(5.0),
            bottomLeft: Radius.circular(5.0),
            bottomRight: Radius.circular(10.0),
          )
        : BorderRadius.only(
            topRight: Radius.circular(5.0),
            bottomLeft: Radius.circular(10.0),
            bottomRight: Radius.circular(5.0),
          );
    final itemMargin = messageModel.isMe
        ? const EdgeInsets.fromLTRB(100, 3, 3, 3)
        : const EdgeInsets.fromLTRB(3, 3, 100, 3);
    return Column(
      crossAxisAlignment: align,
      children: <Widget>[
        Container(
          margin: itemMargin,
          padding: const EdgeInsets.all(8.0),
          decoration: BoxDecoration(
            boxShadow: [
              BoxShadow(
                  blurRadius: .5,
                  spreadRadius: 1.0,
                  color: Colors.black.withOpacity(.12))
            ],
            color: bg,
            borderRadius: radius,
          ),
          child: Stack(
            children: <Widget>[
              Padding(
                padding: EdgeInsets.only(right: 90.0),
                child: Text(messageModel.message),
              ),
              Positioned(
                bottom: 0.0,
                right: 0.0,
                child: Row(
                  children: <Widget>[
                    Text(messageModel.time,
                        style: TextStyle(
                          color: Colors.black38,
                          fontSize: 10.0,
                        )),
                    Icon(
                      icon,
                      size: 12.0,
                      color: Colors.black38,
                    )
                  ],
                ),
              )
            ],
          ),
        )
      ],
    );
  }
}
