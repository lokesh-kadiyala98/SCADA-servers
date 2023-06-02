# SCADA Servers Project

This project provides a SCADA system server with the ability to subscribe to updates for specific tags and update the display when the tag values change.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You'll need to have the following software installed on your system before you proceed.

- Java 18
- Maven
- Spring Boot
- Websocket support
- An IDE like IntelliJ IDEA or Eclipse

### Installing

Follow these steps to get the project running on your local machine.

1. Clone the repository: `git clone https://github.com/yourusername/scada-servers.git`
2. Navigate into the directory: `cd scada-servers`
3. Install the dependencies: `mvn install`
4. Run the application: `mvn spring-boot:run`

The server should now be running at `http://localhost:8080`.

## Usage

To subscribe to a specific SCADA tag from a JS client:

```javascript
const socket = new WebSocket('ws://localhost:8080/ws/scada-tags');

socket.onopen = () => {
    console.log('Connected');
    socket.send('scadaTagName'); // Replace 'scadaTagName' with the name of the tag you want to subscribe to.
};

socket.onmessage = (event) => {
    console.log('Received:', event.data);
};

socket.onclose = () => {
    console.log('Connection closed');
};
