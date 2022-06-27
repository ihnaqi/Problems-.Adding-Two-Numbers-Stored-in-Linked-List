## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `.gitignore` the file to avoid commiting files and directories on github which shoudn't be commited.

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Problem Description

In the given project we have a linked list of integers, each node has a vale from 0 to 9, the linked list store a number but the number is stored in reverse order. For example contnet of a linked list are 9 -> 8 -> 7 -> 0 -> 1 the resulting numbers should be 10789. Two linked lists of the same nature are supposed to be added and stored in the same order.

## An example

List1: 9 -> 9 -> 0 -> 5
List2: 5 -> 4 -> 1

Number1: 5099
Number2: 145

Summation: 5099 + 145 = 5241

Resulting List: 1 -> 4 -> 2 -> 5
