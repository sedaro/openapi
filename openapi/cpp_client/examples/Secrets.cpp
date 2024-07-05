#include <iostream>
#include <fstream>
#include <string>
#include <map>

#include <Secrets.h>

Secrets::Secrets() {}

// Getter method to get a value corresponding to a given key from config.properties
std::string Secrets::get(const std::string& key) {
    std::ifstream input("./resources/config.properties");
    std::map<std::string, std::string> prop;

    if (!input) {
        throw std::runtime_error("Failed to open config.properties");
    }

    std::string line;
    while (std::getline(input, line)) {
        std::size_t found = line.find_first_of(" = ");
        if (found != std::string::npos) {
            std::string key = line.substr(0, found);
            std::string value = line.substr(found + 3);
            prop[key] = value;
        }
    }

    input.close();

    auto it = prop.find(key);
    if (it != prop.end()) {
        return it->second;
    } else {
        throw std::runtime_error("Key not found in config.properties");
    }
}