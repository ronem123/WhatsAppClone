import 'package:flutter/material.dart';
import 'package:toast/toast.dart';

import '../models/call_model.dart';

class CallingScreen extends StatelessWidget {
  BuildContext context;
  final CallModel callData;

  CallingScreen({this.callData});

  @override
  Widget build(BuildContext context) {
    this.context = context;
//    SystemChrome.setEnabledSystemUIOverlays([]);

    return Material(
        type: MaterialType.transparency,
        child: Container(
            decoration: new BoxDecoration(color: Color(0xff075E54)),
            child: Stack(
              children: <Widget>[
                Align(alignment: Alignment.topCenter, child: getUpperView()),
                Align(alignment: Alignment.center, child: getMidView()),
                Align(alignment: Alignment.bottomCenter, child: getCallView()),
                Align(alignment: Alignment.bottomCenter, child: getBottomView())
              ],
            )));
  }

  Widget getUpperView() {
    return new Container(
      padding: EdgeInsets.fromLTRB(30, 40, 30, 20),
      child: new Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          new Row(
            children: <Widget>[
              new Image.asset(
                "assets/images/whatsapp_icon.png",
                height: 15,
                width: 15,
              ),
              Padding(
                  padding: const EdgeInsets.only(left: 5),
                  child: new Text(
                    "WHATS APP CALL",
                    style: new TextStyle(
                        fontSize: 12,
                        fontWeight: FontWeight.bold,
                        color: Colors.white30),
                  ))
            ],
          ),
          Padding(
            padding: const EdgeInsets.only(top: 2),
            child: new Text(callData.name,
                style: TextStyle(
                    fontSize: 30,
                    color: Colors.white70,
                    fontWeight: FontWeight.normal),
                textAlign: TextAlign.left),
          ),
          Padding(
            padding: const EdgeInsets.only(top: 10),
            child: new Text(callData.dateTime,
                style: TextStyle(
                    fontSize: 14,
                    color: Colors.white30,
                    fontWeight: FontWeight.normal),
                textAlign: TextAlign.left),
          ),
        ],
      ),
    );
  }

  Widget getMidView() {
    return new Container(
        padding: new EdgeInsets.only(top: 20),
        child: Image.network(
          callData.avatarImageUrl,
          fit: BoxFit.fill,
        ));
  }

  Widget getCallView() {
    return Padding(
      padding: new EdgeInsets.only(bottom: 100),
      child: Container(
        height: 80,
        width: 80,
        padding: new EdgeInsets.all(26),
        decoration:
            new BoxDecoration(shape: BoxShape.circle, color: Colors.red),
        child: Image.asset(
          "assets/images/call.png",
          height: 20,
          width: 20,
          color: Colors.white,
        ),
      ),
    );
  }

  Widget getDividerView() {
    return new Divider(
      height: 10,
    );
  }

  Widget getBottomView() {
    return Padding(
      padding: new EdgeInsets.all(20),
      child: new Row(children: <Widget>[
        Expanded(
            child: GestureDetector(
          onTap: () {
            showMessage("on Hand free clicked");
          },
          child: Image.asset("assets/images/speaker.png",
              height: 20, width: 20, color: Colors.white70),
        )),
        Expanded(
            child: GestureDetector(
          onTap: () {
            showMessage("Message clicked");
          },
          child: Image.asset("assets/images/msg.png",
              height: 20, width: 20, color: Colors.white70),
        )),
        Expanded(
            child: GestureDetector(
          onTap: () {
            showMessage("Mic clicked");
          },
          child: Image.asset("assets/images/mic.png",
              height: 20, width: 20, color: Colors.white70),
        ))
      ]),
    );
  }

  void showMessage(String msg) {
//    Navigator.pushNamed(context, '/calling');
    Toast.show(msg, context,
        duration: Toast.LENGTH_SHORT, gravity: Toast.BOTTOM);
  }
}

//child: new Column(
//children: <Widget>[
//new Flexible(
//child: getUpperView(),
//flex: 0,
//),
//new Flexible(
//child: getMidView(),
//flex: 1,
//),
//getDividerView(),
//new Flexible(
//child: getBottomView(),
//flex: 0,
//)
//],
//)
