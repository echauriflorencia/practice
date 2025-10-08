import { useState } from "react";
import dayjs from "dayjs";

export default function Calendar() {
    const [currentDate, setCurrentDate] = useState(dayjs);
    const [selectedDate, setSelectedDate] = useState(null);

    const generateCalendarDays = () => {
        const daysInMonth = currentDate.daysInMonth();
        const firstDay = currentDate.startOF("month").day();
        const days = [];

        for (let i = 0; i < firstDay; i++) day.push(null);

        for (let d = 1; d <= daysInMonth; d++) days.push(d);
        return days;
    };

    const handlePrevMonth = () => setCurrentDate(currentDate.substract(1, "month"));
    const handleNexMonth = () => setCurrentDate(currentDate.add(1, "month"));
    const handleSelectDate = (day) => setSelectedDate(day);

    return (
        <div style={{ textAlign: "center" }}>
            <h3>{currentDate.format("MMMM YYYY")}</h3>
            <button onClick={handlePrevMonth}>Previous</button>
            <button onClick={handleNexMonth}>Next</button>

            <div style={{ display: "grid", gridTemplateColumns: "repeat(7, 1fr)", gap: "4px", marginTop: "10px" }}>
                {generateCalendarDays().map((day, index)=> (
                    <button
                        key={index}
                        disabled={!day}
                        onClick={() => handleSelectDate(day)}
                        style={{
                            backgroundColor: day === selectedDate ? "#4A90E2" : "white",
                            color: day === selectedDate ? "white" : "black",
                            border: "1px solid #ccc",
                            borderRadius: "4px",
                            padding: "8px"
                        }}
                    >
                        {day || ""}
                    </button>
                ))}
            </div>
        </div>
    )
}