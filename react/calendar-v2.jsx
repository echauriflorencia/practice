import dayjs from "dayjs";
import { useState } from "react";

function useCalendar(events) {
  const [currentMonth, setCurrentMonth] = useState(dayjs()); // ejemplo: Oct 2025
  const [selectedDate, setSelectedDate] = useState(null);

  // Generar los días del mes actual (1–31)
  function getMonthDays() {
    const start = currentMonth.startOf("month");
    const end = currentMonth.endOf("month");
    const days = [];

    for (let i = 0; i < end.date(); i++) {
      const date = start.add(i, "day");
      days.push(date.format("YYYY-MM-DD"));
    }
    return days;
  }

  // Mover a otro mes
  function goToNextMonth() {
    setCurrentMonth(currentMonth.add(1, "month"));
  }

  function goToPrevMonth() {
    setCurrentMonth(currentMonth.subtract(1, "month"));
  }

  // Seleccionar fecha
  function selectDate(date) {
    setSelectedDate(date);
  }

  // Filtrar eventos del día seleccionado
  function getEventsForSelectedDate() {
    if (!selectedDate) return [];
    return events.filter((e) => e.date === selectedDate);
  }

  return {
    currentMonth: currentMonth.format("MMMM YYYY"),
    days: getMonthDays(),
    selectedDate,
    goToNextMonth,
    goToPrevMonth,
    selectDate,
    eventsForSelectedDate: getEventsForSelectedDate(),
  };
}
