import 'package:flutter/material.dart';

class StatusScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Container(
      decoration: new BoxDecoration(color: Colors.white),
      child: new Column(
        children: <Widget>[
          Container(
            padding: new EdgeInsets.fromLTRB(10, 0, 10, 0),
            child: Column(
              children: <Widget>[
                new ListTile(
                  leading: new CircleAvatar(
                    foregroundColor: Theme.of(context).primaryColor,
                    backgroundColor: Colors.grey,
                    backgroundImage: new NetworkImage(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Circle-icons-profile.svg/1024px-Circle-icons-profile.svg.png"),
                  ),
                  title: new Text("My Status"),
                  subtitle: new Text("Tap to add status update"),
                )
              ],
            ),
          ),
          new Container(
              decoration: BoxDecoration(color: Colors.black12),
              padding: new EdgeInsets.all(20),
              child: Row(
                children: <Widget>[
                  Text(
                    "Recent updates",
                    textAlign: TextAlign.left,
                    style: new TextStyle(
                        color: Colors.black87,
                        fontSize: 16,
                        fontWeight: FontWeight.bold),
                  ),
                ],
              )),
          Container(
            color: Colors.white,
            padding: new EdgeInsets.fromLTRB(10, 0, 10, 0),
            child: Column(
              children: <Widget>[
                new ListTile(
                  leading: new CircleAvatar(
                    child: Image.asset("assets/images/whatsapp_icon.png"),
                  ),
                  title: new Row(
                    children: <Widget>[
                      new Text(
                        "WhatsApp",
                        style: TextStyle(
                            fontWeight: FontWeight.bold,
                            color: new Color(0xff075E54)),
                      ),
                      new Container(
                        height: 20,
                        width: 20,
                        padding: new EdgeInsets.fromLTRB(5, 0, 0, 0),
                        child: Image.asset("assets/images/check.png"),
                      )
                    ],
                  ),
                )
              ],
            ),
          ),
        ],
      ),
    );
  }
}
