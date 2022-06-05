package exceptions1.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions1.model.exceptions.DomainException;

public class Reserva {

  private Integer roomNumber;
  private Date checkIn;
  private Date checkOut;
  
  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  
  public Reserva(Integer roomNumber, Date checkIn, Date checkOut) {
      if (!checkOut.after(checkIn)) {
          throw new DomainException("A data de check-out deve ser posterior à data de check-in");
      }
      this.roomNumber = roomNumber;
      this.checkIn = checkIn;
      this.checkOut = checkOut;
  }

  public Integer getRoomNumber() {
      return roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
      this.roomNumber = roomNumber;
  }

  public Date getCheckIn() {
      return checkIn;
  }

  public Date getCheckOut() {
      return checkOut;
  }

  public long duracao() {
      long diferenca = checkOut.getTime() - checkIn.getTime();
      return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
  }
  
  public void updateDates(Date checkIn, Date checkOut) {
      Date now = new Date();
      if (checkIn.before(now) || checkOut.before(now)) {
          throw new DomainException("As datas de reserva para atualização devem ser datas futuras");
      }
      if (!checkOut.after(checkIn)) {
          throw new DomainException("A data de check-out deve ser posterior à data de check-in");
      }
      this.checkIn = checkIn;
      this.checkOut = checkOut;
  }
  
  @Override
  public String toString() {
      return "Quarto "
          + roomNumber
          + ", check-in: "
          + sdf.format(checkIn)
          + ", check-out: "
          + sdf.format(checkOut)
          + ", "
          + duracao()
          + " noites";
  }
  
}
