# Java Socket



## Getting started

A couple of sample Java classes that will allow you to open a socket so that you can trace it with Wireshark and look at the behaviour at OS level
## How to 

- [ ] Choose a set of matching classes (TCP or UDP)
- [ ] Start the server class, will listen on port 7654
- [ ] Start the client and enter localhost as server name or address (IPv4 or IPv6)

## Observe behaviour on OS level
On Windows

- [ ] Open a command prompt once the programs are running
- [ ] At the prompt type: netstat -an | findstr 7654
- [ ] This should return the socket status


## Observe behaviour in Wireshark

- [ ] Open Wireshark and start capture
- [ ] Once capture is started you can start the programs and observe who the connection is established
- [ ] Use tcp.port == 7654 or udp.port == 7654 as filter depending on the use case you're testing

## Extra 

- [ ] Redo the same exercise but now have the client and server running on different laptops
- [ ] On the client side you'll have to specify the IP address of the laptop you want to reach instead of localhost
- [ ] Don't forget to turn off firewall momentarily to allow the connections
- [ ] Do the same exercise but use IPv6 instead 
