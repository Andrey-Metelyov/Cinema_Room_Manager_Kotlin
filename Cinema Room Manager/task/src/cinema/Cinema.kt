package cinema

import kotlin.system.exitProcess

fun main() {
    // write your code here
    System.err.println(Thread.currentThread())
    println("Enter the number of rows:")
    val rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    val cols = readLine()!!.toInt()
//    showIncome(rows, cols)
    val grid = Array<CharArray>(rows) { CharArray(cols) {'S'} }
    menu(grid)
//    show(grid)
//    soldTicket(grid)
//    show(grid)
}

fun menu(grid: Array<CharArray>) {
    while (true) {
        println(
            "\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit"
        )
        val choice = readLine()!!.toInt()
        System.err.println("choice = $choice")
        when (choice) {
            1 -> show(grid)
            2 -> soldTicket(grid)
            0 -> return
            else -> println("wrong choice")
        }
    }
}

fun exit() {
    System.err.println("exiting")
    exitProcess(0)
}

fun soldTicket(grid: Array<CharArray>) {
    println("\nEnter a row number:")
    val row = readLine()!!.toInt()
    println("Enter a seat number in that row:")
    val seat = readLine()!!.toInt()
    grid[row - 1][seat - 1] = 'B'
    println("Ticket price: $${getTicketPrice(row, seat, grid)}")
}

fun getTicketPrice(row: Int, seat: Int, grid: Array<CharArray>): Int {
    val totalSeats = grid.size * grid[0].size
    if (totalSeats <= 60) {
        return 10
    }
    if (row <= grid.size / 2) {
        return 10
    }
    return 8
}

fun showIncome(rows: Int, cols: Int) {
    val totalSeats = rows * cols
    println("Total income:\n" + "$" +
        if (totalSeats > 60) rows / 2 * cols * 10 + (rows - rows / 2) * cols * 8 else totalSeats * 10)
}

fun show(grid: Array<CharArray>) {
    println("\nCinema:")
    println("  ${(1..grid[0].size).joinToString(" ")}")
    for (i in 1..grid.size) {
        println("$i ${grid[i - 1].joinToString(" ")}")
    }
}
