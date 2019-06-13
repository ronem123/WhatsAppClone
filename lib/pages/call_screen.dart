import 'package:flutter/material.dart';
import '../models/call_model.dart';

class CallsScreen extends StatefulWidget {
  @override
  CallsScreenState createState() {
    return new CallsScreenState();
  }
}

class CallsScreenState extends State<CallsScreen> {
  @override
  Widget build(BuildContext context) {
    return new ListView.builder(
      itemCount: callList.length,
      itemBuilder: (context, i) => new Column(
            children: <Widget>[
              new Divider(
                height: 10.0,
              ),
              new ListTile(
                leading: new CircleAvatar(
                  foregroundColor: Theme.of(context).primaryColor,
                  backgroundColor: Colors.grey,
                  backgroundImage: new NetworkImage(callList[i].avatarImageUrl),
                ),
                title: new Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    new Text(
                      callList[i].name,
                      style: new TextStyle(fontWeight: FontWeight.bold),
                    ),
                    new Image.asset(
                      "assets/images/call.png",
                      color: Color(0xff075E54),
                      height: 23,
                      width: 23,
                    )
                  ],
                ),
                subtitle: Container(
                  padding: new EdgeInsets.only(top: 5),
                  child: new Row(
                    children: <Widget>[
                      new Image.asset(
                        callList[i].inOutCallImageUrl,
                        height: 20,
                        width: 20,
                        color: Color(int.parse(callList[i].color)),
                      ),
                      Container(
                          padding: new EdgeInsets.only(left: 10),
                          child: new Text(
                            callList[i].dateTime,
                            style: new TextStyle(fontSize: 14.0),
                          )),
                    ],
                  ),
                ),
              )
            ],
          ),
    );
  }
}
